package com.cocolife.util.sqlbuilder;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oris.base.BaseDao;
import com.oris.enums.RolesEnum;
import com.oris.util.sqlbuilder.SqlBuilderAbstractVO;
import com.oris.util.sqlbuilder.SqlBuilderException;
import com.oris.util.sqlbuilder.SqlBuilderFactory;

import static org.junit.Assert.*;

/**
 * 
 * @author Ross Zarsuela
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/resource/services-config-test.xml"})
public class SqlBuilderFactoryDaoTest {
	@Autowired
	private BaseDao baseDao;
	private SqlBuilderFactory sqlFactory;
	
	@Before
	public void setup(){
		sqlFactory = new SqlBuilderFactory();
	}
	
	@Test
	public void shouldInitialize() {
		assertNotNull(baseDao);
	}
	
	@Test
	public void shouldTestSimpleSelect() throws SqlBuilderException {
		String sql = sqlFactory.select("usr_username_pk").from("Users").getSql();
		List<SqlBuilderAbstractVO> list = baseDao.executeSqlQuery(sql);
		assertNotNull(list);
		
	}
	
	@Test
	public void shouldTestSimpleDistinct() throws SqlBuilderException {
		String sql = sqlFactory.select().distinct("usr_username_pk", "usr_rl_id_fk").from("Users").getSql();
		List<SqlBuilderAbstractVO> list = baseDao.executeSqlQuery(sql);
		assertNotNull(list);
		
	}
	
	@Test
	public void shouldTestSimpleWhere() throws SqlBuilderException {
		sqlFactory.select("usr_username_pk", "usr_password")
						.from("Users")
						.where().like("usr_username_pk", "%a%")
						.and().equal("usr_rl_id_fk", RolesEnum.SYSTEM_ADMIN.getId());
		System.out.println(sqlFactory.getSql());
		List<SqlBuilderAbstractVO> list =  baseDao.executeSqlQuery(sqlFactory.getSql());
		assertNotNull(list);
		
	}
	
	@Test
	public void shouldTestComplexQuery() throws SqlBuilderException {
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 1, 28);
		Date startDate = cal.getTime();
		cal.set(2013, 2, 12);
		Date endDate = cal.getTime();
		
		
		sqlFactory.select("csh.csh_id_pk as objId",
								  "csh.csh_ref_no as refNo",  
								  "csh.csh_total_plan_payment as totalPlan",  
								  "prov.prov_business_name as provName",  
								  "naprov.nap_business_name as naProvName",  
								  "doc.doc_firstname as docFn",  
								  "doc.doc_lastname as docLn",  
								  "nadoc.nad_first_name as naDocFn",  
								  "nadoc.nad_last_name as naDocLn",  
								  "mem.mem_firstname as memFn",  
								  "mem.mem_lastname as memLn",  
								  "nonmem.nm_firstname as nonMemFn",  
								  "nonmem.nm_lastname as nonMemLn",  
								  "tempmem.tmp_mem_firstname as tempMemFn",  
								  "tempmem.tmp_mem_lastname as tempMemLn",  
								  "csh.csh_created_by as processor",  
								  "csh.csh_create_date as createDate")
						.from("computation_sheets_head csh")
							.leftJoin("providers prov").on("prov.prov_id_pk", "csh.csh_prov_id_fk")
							.leftJoin("non_accredited_provider naprov").on("naprov.nap_id_pk", "csh_non_acc_prov_id_fk")
							.leftJoin("doctors doc").on("doc.doc_id_pk", "csh.csh_doc_id_fk")
							.leftJoin("non_accredited_doctor nadoc").on("nadoc.nad_id_pk", "csh.csh_non_acc_doc_id_fk")
							.leftJoin("members mem").on("mem.mem_id_pk", "csh.csh_mem_id_fk")
							.leftJoin("non_member nonmem").on("nonmem.nm_id_pk", "csh.csh_non_mem_id_fk")
							.leftJoin("temp_members tempmem").on("tempmem.tmp_mem_id_pk", "csh.csh_temp_mem_id_fk")
						.where().isNull("csh.csh_rfp_id_pk").and()
									.equal("csh.csh_status", 1).and()
									.equal("csh.csh_created_by", "claimprc").and()
									.ge("csh.csh_create_date", startDate).and()
									.le("csh.csh_create_date", endDate);
		System.out.println(sqlFactory.getSql());
		List<SqlBuilderAbstractVO> list =  baseDao.executeSqlQuery(sqlFactory.getSql());
		assertNotNull(list);
		
	}
	
	@Test
	public void shouldTestAggregateFunctions() throws SqlBuilderException {
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 1, 28);
		Date startDate = cal.getTime();
		cal.set(2013, 2, 12);
		Date endDate = cal.getTime();
		
		
		sqlFactory.select(/*"rfp.cr_id_pk as objId",
								  "rfp.cr_batch_no as batchNo",  
								  "rfp.cr_rfp_no as rfpNo",  
								  "rfp.cr_created_by as processor",  
								  "rfp.cr_create_date as createDate"*/)
								  .max("prov.prov_business_name").as("provName")
								  .max("naprov.nap_business_name").as("naProvName")
								  .max("doc.doc_firstname").as("docFn")
								  .max("doc.doc_lastname").as("docLn")
								  .max("nadoc.nad_first_name").as("naDocFn")
								  .max("nadoc.nad_last_name").as("naDocLn")
								  .max("mem.mem_firstname").as("memFn")
								  .max("mem.mem_lastname").as("memLn")
								  .max("nonmem.nm_firstname").as("nonMemFn")
								  .max("nonmem.nm_lastname").as("nonMemLn")
								  .max("tempmem.tmp_mem_firstname").as("tempMemFn")
								  .max("tempmem.tmp_mem_lastname").as("tempMemLn")
						.from("claims_rfp rfp")
							.innerJoin("computation_sheets_head csh").on("rfp.cr_id_pk", "csh.csh_rfp_id_pk")
							.leftJoin("providers prov").on("prov.prov_id_pk", "csh.csh_prov_id_fk")
							.leftJoin("non_accredited_provider naprov").on("naprov.nap_id_pk", "csh_non_acc_prov_id_fk")
							.leftJoin("doctors doc").on("doc.doc_id_pk", "csh.csh_doc_id_fk")
							.leftJoin("non_accredited_doctor nadoc").on("nadoc.nad_id_pk", "csh.csh_non_acc_doc_id_fk")
							.leftJoin("members mem").on("mem.mem_id_pk", "csh.csh_mem_id_fk")
							.leftJoin("non_member nonmem").on("nonmem.nm_id_pk", "csh.csh_non_mem_id_fk")
							.leftJoin("temp_members tempmem").on("tempmem.tmp_mem_id_pk", "csh.csh_temp_mem_id_fk")
						.where().isNull("rfp.cr_crt_id_fk").and()
									.isNull("rfp.cr_ccp_id_fk").and()
									.equal("rfp.cr_status", 1).and()
									.equal("csh.csh_created_by", "claimprc").and()
									.between("rfp.cr_batch_no", "0000000390", "0000000430").and()
									.ge("rfp.cr_create_date", startDate).and()
									.le("rfp.cr_create_date", endDate)
							.groupBy("rfp.cr_id_pk",
									"rfp.cr_batch_no",
									"rfp.cr_rfp_no",
									"rfp.cr_created_by",
									"rfp.cr_create_date")
							.orderBy("rfp.cr_rfp_no", "DESC");
		System.out.println(sqlFactory.getSql());
		List<SqlBuilderAbstractVO> list =  baseDao.executeSqlQuery(sqlFactory.getSql());
		assertNotNull(list);
		
	}
	
	@Test
	public void shouldTestSimpleEqual() throws SqlBuilderException {
		sqlFactory.select("usr_username_pk", "usr_password")
						.from("Users")
						.where().equal("usr_rl_id_fk", RolesEnum.SYSTEM_ADMIN.getId());
		System.out.println(sqlFactory.getSql());
		List<SqlBuilderAbstractVO> list =  baseDao.executeSqlQuery(sqlFactory.getSql());
		assertNotNull(list);
		
	}
	
	/*@Test
	public void shouldTestSimpleLike() {
		
	}
	
	@Test
	public void shouldTestSimpleAnd() {
		
	}
	
	@Test
	public void shouldTestSimpleOr() {
		
	}*/
	
	@After
	public void tearDown(){
		sqlFactory = null;
	}
}
