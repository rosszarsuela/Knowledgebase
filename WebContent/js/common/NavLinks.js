

document.writeln('<div class="user_bar">');
document.writeln('<div id="header-pane">');
document.writeln('<div id="nav-top-pane">');
document.writeln( '<ul class="main-nav">');

/*-----------------------------------------------------------------------------------------------*/
/*                                         MIS/IT                                       */
/*-----------------------------------------------------------------------------------------------*/
document.writeln('<li id="main-nav-list">');
document.writeln('<img src="../icon/mis.png" height="20px" width="20px" style="vertical-align: middle;">');
document.writeln('<a href="#" id="main-nav-a" rel="personnel">MIS & IT</a>');
document.writeln('<ul class="sub-nav">');
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">MIS & IT</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');

/*-----------------------------------------------------------------------------------------------*/
/*                                         PROVIDER                                       */
/*-----------------------------------------------------------------------------------------------*/
function search_hosp(){
    $('#search_hospital').click(function(){
        $('.grid-bg').hide();
        $('.container_form').hide();
        $('#grid-hosp').show();
        $('#main').hide();
    //        $('#provider_viewdoctors').hide();
    })
};
function prov_viewdoctors(){
    $('#viewdoctors').click(function(){
        $('.grid_bg').hide();
        $('.container_form').hide();
        $('#main').hide();
        //        $('#grid_hosp').hide();
        $('#provider_viewdoctors').show();
    })
};
function prov_addhospital(){
    $('#addhospital').click(function(){
        $('.grid_bg').hide();
        $('.container_form').hide();
        $('#main').hide();
        //        $('#grid_hosp').hide();
        $('#provider_addhospital').show();
    })
};

document.writeln( '<li id="main-nav-list">');
document.writeln( '<img src="../icon/provider.png" height="20px" width="20px" style="vertical-align: middle;">');
document.writeln( '<a href="#" id="main-nav-a" >Provider</a>');

document.writeln( '<ul class="sub-nav">');
document.writeln( '<li id="sub-nav-list">');
document.writeln( '<a href="#" id="sub-nav-a">Add Provider &rsaquo;&rsaquo;</a>');
document.writeln( '<ul class="inner-nav">');
document.writeln( '<li id="sub-inner-list">');
document.writeln(  '<a href="javascript: prov_addhospital()" id="addhospital" class="sub-inner-a">Hospital/Clinic</a></li>');
document.writeln( '<li id="sub-inner-list"><a href="" class="sub-inner-a">Doctors</a></li>');
document.writeln( '</ul>');
document.writeln( '</li>');

document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="#" id="sub-nav-a">View &rsaquo;&rsaquo;</a>');
document.writeln('<ul class="inner-nav">');
document.writeln('<li id="sub-inner-list">');

document.writeln('<a href="javascript:search_hosp()" class="sub-inner-a" id="search_hospital">Hospital/Clinic</a></li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:prov_viewdoctors()" id="viewdoctors" class="sub-inner-a">Doctors</a></li>');
document.writeln('</ul>');
document.writeln('</li>');

document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="#" id="sub-nav-a">APE LOA Issuance</a>');
document.writeln('</li>');
document.writeln('</ul>');
/*-----------------------------------------------------------------------------------------------*/
/*                                         MARKETING                                        */
/*-----------------------------------------------------------------------------------------------*/
function mar_profiling(){
    $('#profiling').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#marketing_profiling').show();
    })
};
function mar_monitoring(){
    $('#monitoring').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#tablist_monitoring').show();
        $('#marketingmain_monitoring').show();
    })
};
function mar_viewinternalsource(){
    $('#viewinternalsource').click(function(){

        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#marketing_viewinternalsource').show();
    })
};
function mar_internalsource(){
    $('#internalsource').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#internal_source').show();
    })
};
function mar_addprospected(){
    $('#addprospected').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#tablist_addprospected').show();
        $('#mp1').show();
        $('#marketingmain_addprospected').show();
    })
};
function mar_sob(){
    $('#sob').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#mainsob').show();
    })
};
function mar_viewaccounts(){
    $('#viewaccounts').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#proposal_viewaccounts').show();
    })
};
function mar_editforproposal(){
    $('#editforproposal').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#efp1').show();
        $('#tablist_editforproposal').show();
        $('#marketing_editforproposal').show();
    })
};
function mar_aftersales(){
    $('#aftersales').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#marketing_aftersalesandrenewal').show();
    })
};
function mar_specialandother(){
    $('#specialandother').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#specialandotherendorsements').show();
    })
};
function mar_scheduler(){
    $('#scheduler').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#marketing_scheduler').show();
    })
};
function mar_viewexpiring(){
    $('#viewexpiring').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#viewexpiringaccounts').show();
    })
    $('#renewexpiring').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#viewexpiringaccounts').hide();
        $('#tablist_renewexpiring').show();
        $('#marketing_renewexpiringaccounts').show();
    })
    $('#extendexpiring').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#viewexpiringaccounts').hide();
        $('#tablist_renewexpiring').hide();
        $('#marketing_renewexpiringaccounts').hide();
        $('#tablist_extendexpiring').show();
        $('#marketing_extendexpiringaccounts').show();
    })
};
function mar_outgoingdocs(){
    $('#outgoingdocs').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#marketing_outgoingdocs').show();
    })
};
function mar_viewaccountsource(){
    $('#viewaccountsource').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#marketing_viewaccountsource').show();
    })
};
function mar_accountsource(){
    $('#accountsource').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#1').show();
        $('#tablist').show();
        $('#marketing_accountsource').show();
    })
};
function mar_viewprospectedaccount(){
    $('#viewprospectedaccount').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#mp1').show();
        $('#marketing_viewprospectedaccount').show();
    })
    $('#edit_prospected').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#mp1').show();
        $('#tablist_addprospected').show();
        $('#marketingmain_addprospected').show();

    })
};

function mar_viewaccountsforproposal(){
    $('#viewaccountsforproposal').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#marketing_viewaccountsforproposal').show();
        
    })
};
function mar_viewgeneratedcoc(){
    $('#viewgeneratedcoc').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#marketing_viewgeneratedcoc').show();
        
    })
};
function mar_viewaccountsforcosting(){
    $('#viewaccountsforcosting').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#marketing_viewaccountsforcosting').show();
        
    })
};
function mar_newaccounts(){
    $('#newaccounts').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#na1').show();
        $('#marketing_newaccounts').show();
    })
    $('#edit_newaccounts').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#marketing_viewaccounts').hide();
        $('#tablist_editnewaccounts').show();
        $('#marketing_editnewaccounts').show();
    })
};
function mar_viewaccounts(){
    $('#viewaccounts').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#marketing_viewaccounts').show();
    })
    $('#viewsubgroups').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#marketing_viewsubgroups').show();
    })
    $('#edit_subgroups').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#tablist').show();
        $('#marketing_accountsource').show();
    })
};
//MARKETING
document.writeln('<li id="main-nav-list">');
document.writeln('<img src="../icon/marketing.png" height="20px" width="20px" style="vertical-align: middle;">');
document.writeln('<a href="#" id="main-nav-a" >Marketing</a>');

//ACCOUNT SOURCE
document.writeln('<ul class="sub-nav">');
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">Account Source &rsaquo;&rsaquo;</a>');
document.writeln('<ul class="inner-nav">');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_internalsource()" id="internalsource" class="sub-inner-a">');
document.writeln('Add Internal Source');
document.writeln('</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_accountsource()" id="accountsource" class="sub-inner-a">');
document.writeln('Add Account Source');
document.writeln('</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_viewinternalsource()" class="sub-inner-a" id="viewinternalsource">View Internal Sorce</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_viewaccountsource()" class="sub-inner-a" id="viewaccountsource">View Account Source</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');

//PROSPECTING MARKETING
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="#" id="sub-nav-a">Prospecting &rsaquo;&rsaquo;</a>');

document.writeln('<ul class="inner-nav">');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_addprospected()" class="sub-inner-a" id="addprospected">Add Prospected Account</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_viewprospectedaccount()" id="viewprospectedaccount" class="sub-inner-a">View Prospected Account</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');

//PROPOSAL MARKETING
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">Proposal &rsaquo;&rsaquo;</a>');

//VIEW ACCOUNTS MARKETING
document.writeln('<ul class="inner-nav">');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_viewaccountsforproposal()" id="viewaccountsforproposal" class="sub-inner-a">View General Proposal</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_viewaccountsforcosting()" id="viewaccountsforcosting" class="sub-inner-a">View Accounts for Costing</a>');
document.writeln('</li>');
//document.writeln('<li id="sub-inner-list">');
//document.writeln('<a href="javascript:mar_costing()" id= "costing" class="sub-inner-a">Costing</a>');
//document.writeln('</li>');
//MONITORING MARKETING 
//document.writeln('<li id="sub-inner-list">');
//document.writeln('<a href="javascript:mar_monitoring()" id="monitoring" class="sub-inner-a">Policy Contract</a>');
//document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');

//POLICY CONTRACT
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" class="policycontract" id="sub-nav-a">Policy Contract &rsaquo;&rsaquo;</a>');

document.writeln('<ul class="inner-nav">');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_viewaccounts()" class="sub-inner-a" id="viewaccounts">View Accounts</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" id="" class="sub-inner-a">View Generated COC</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');

//POLICY SET-UP
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" class="policycontract" id="sub-nav-a">Policy Set-up &rsaquo;&rsaquo;</a>');

document.writeln('<ul class="inner-nav">');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_newaccounts()" class="sub-inner-a" id="newaccounts">New Accounts</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" id="" class="sub-inner-a">View Endorsement Forms</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');

//ACCOUNT MAINTENANCE
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" class="policycontract" id="sub-nav-a">Account Maintenance &rsaquo;&rsaquo;</a>');

document.writeln('<ul class="inner-nav">');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_aftersales()" class="sub-inner-a" id="aftersales">After Sales & Renewal</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_specialandother()" class="sub-inner-a" id="specialandother">Special & Other Endorsements</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_scheduler()" class="sub-inner-a" id="scheduler">View Scheduled Accounts</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_outgoingdocs()" class="sub-inner-a" id="outgoingdocs">Outgoing Documents Logs</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');

//VIEW EXPIRING ACCOUNTS
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" class="policycontract" id="sub-nav-a">View Expiring Accounts &rsaquo;&rsaquo;</a>');

document.writeln('<ul class="inner-nav">');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_viewexpiring()" class="sub-inner-a" id="viewexpiring">Renew / Extend</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:mar_viewgeneratedcoc()" id="viewgeneratedcoc" class="sub-inner-a">View Generated COC</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');
//policy Contract

document.writeln('</ul>');
document.writeln('</li>');

/*-----------------------------------------------------------------------------------------------*/
/*                                         ADMIN                                      */
/*-----------------------------------------------------------------------------------------------*/
function admin_otherendorsements_cancel(){
    $('#cancel').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#otherendorsements_cancel').show();
    })
};
function admin_otherendorsements_extend(){
    $('#extend').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#otherendorsements_extend').show();
    })
};
function admin_newmember(){
    $('#newmember').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#tablist_newpolicy').show();
        $('#admin_newmember').show();
    })
};
function admin_batchupload(){
    $('#viewbatchupload').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#admin_viewbatchupload').show();
    })
    $('#upload_batchupload').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#tablist_batchupload').show();
        $('#admin_batchupload').show();
    })
};
function admin_cancellation(){
    $('#cancellation').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#tablist_cancellation').show();
        $('#admin_cancellation').show();
    })
};

function admin_accountsforrenewal(){
    $('#admin_viewaccounts_renewal').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
       // $('#tablist_accountsrenewal').show();
        $('#admin_viewaccounts_renewal').show();
    })
};
function admin_viewaccounts(){
    $('.adminviewaccounts').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#admin_viewaccounts').show();
    })
};
function admin_viewaccounts_renewal(){
    $('.adminviewaccountsrenewal').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#tablist_accountsrenewal').show();
        $('#admin_viewaccounts_renewal').show();
    })
};
function admin_viewmembers(){
    $('#viewmembers').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#admin_viewmembers').show();
    })
    $('#edit_viewdependents').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#admin_viewmembers').hide();
        $('#admin_viewdependents').show();
    })
    $('#edit_memberdetails').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#admin_viewmembers').hide();
        $('#tablist_editmemberdetails').show();
        $('#admin_editmemberdetails').show();
    })
    
};
function adminviewbills(){
    $('#adminviewbills').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#admin_viewbills').show();
    })
};
function adminacctsgeneratebilling(){
    $('#adminacctsgeneratebilling').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#admin_accounts_generatebilling').show();
    })
    $('#admingeneratebillingproper').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#admin_accounts_generatebilling').hide();
        $('#admin_generatebillingproper').show();
        $('#tablist_generatebilling').show();
    })
};
function admin_idissuance(){
    $('.adminidissuance').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#admin_idissuance').show();
    })
    $('#addtoprintfile').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#admin_idissuance_addtoprintfile').show();
    })
};
document.writeln('<li id="main-nav-list">');
document.writeln('<img src="../icon/admin.png" height="20px" width="20px" style="vertical-align: middle;">');
document.writeln('<a href="#" id="main-nav-a" rel="personnel">Admin</a>');
//admin view accounts
document.writeln('<ul class="sub-nav">');
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="javascript:admin_viewaccounts()" class="adminviewaccounts" id="sub-nav-a">View Accounts</a>');
document.writeln('</li>');

//admin view accounts for renewal
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="javascript:admin_viewaccounts_renewal()" class="adminviewaccountsrenewal" id="sub-nav-a">View Accounts for Renewal</a>');
document.writeln('</li>');

//admin - member admin
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">Member Admin &rsaquo;&rsaquo;</a>');
document.writeln('<ul class="inner-nav">');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:admin_newmember()" id="newmember" class="sub-inner-a">');
document.writeln('Member Registration');
document.writeln('</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:admin_batchupload()" id="viewbatchupload" class="sub-inner-a">');
document.writeln('Batch Upload Member');
document.writeln('</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:admin_viewmembers()" id="viewmembers" class="sub-inner-a">View Members</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');

//admin-billing
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">Billing &rsaquo;&rsaquo;</a>');
document.writeln('<ul class="inner-nav">');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:adminacctsgeneratebilling()" id="adminacctsgeneratebilling" class="sub-inner-a">');
document.writeln('Generate Billing');
document.writeln('</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:adminviewbills()" id="adminviewbills" class="sub-inner-a">');
document.writeln('View Bills');
document.writeln('</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');

//id Issuance
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="javascript:admin_idissuance()" class="adminidissuance" id="sub-nav-a">ID Issuance</a>');
document.writeln('</li>');

document.writeln('</ul>');
document.writeln('</li>');

/*-----------------------------------------------------------------------------------------------*/
/*                                         HOTLINE                                       */
/*-----------------------------------------------------------------------------------------------*/
function hotline_calllogging(){
    $('#hotlinecalllogging').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#hotline_calllogging').show();
        $('#hotline_logging').show();
    })
    $('.logging').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#hotline_calllogging').show();
        $('#hotline_logging').show();
        $('#hotline_myreports').hide();
        $('#hotline_myhistory').hide();
    })
    $('.myreports').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#hotline_calllogging').show();
        $('#hotline_logging').hide();
        $('#hotline_myreports').show();
        $('#hotline_myhistory').hide();
    })
    $('.myhistory').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#hotline_calllogging').show();
        $('#hotline_logging').hide();
        $('#hotline_myreports').hide();
        $('#hotline_myhistory').show();
    })
};
function hotline_loaissuance(){
    $('#hotlineloaissuance').click(function(){
        $('.container_form').hide();
        $('.grid-bg').hide();
        $('#hotline_loaissuance').show();
    })
    $('#hotlineissueloa').click(function(){
        $('#hotline_loaissuance').hide();
        $('#tablist_loaissuance').show();
        $('#hotline_issueloa').show();
    })
    $('#hotlineeditloa').click(function(){
        $('#hotline_loaissuance').hide();
        $('#tablist_editloa').show();
        $('#hotline_editloa').show();
    })
};


document.writeln('<li id="main-nav-list">');
document.writeln('<img src="../icon/hotline.png" height="20px" width="20px" style="vertical-align: middle;">');
document.writeln('<a href="#" id="main-nav-a" rel="accounting">Hotline</a>');
//SUB HOTLINE
document.writeln('<ul class="sub-nav">');
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">Hotline &rsaquo;&rsaquo;</a>');

document.writeln('<ul class="inner-nav">');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:hotline_calllogging()" id="hotlinecalllogging" class="sub-inner-a">');
document.writeln('Call Logging');
document.writeln('</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:hotline_loaissuance()" id="hotlineloaissuance" class="sub-inner-a">');
document.writeln('LOA Issuance');
document.writeln('</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="javascript:()" id="" class="sub-inner-a">');
document.writeln('View Accounts');
document.writeln('</a>');
document.writeln('</li>');

document.writeln('</ul>');
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">Health Assist</a>');

document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');
    
/*-----------------------------------------------------------------------------------------------*/
/*                                         CLAIMS                                       */
/*-----------------------------------------------------------------------------------------------*/
document.writeln('<li id="main-nav-list">');
document.writeln('<img src="../icon/claims.png" height="20px" width="20px" style="vertical-align: middle;">');
document.writeln('<a href="#" id="main-nav-a" rel="inventory">Claims</a>');

document.writeln('<ul class="sub-nav">');
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">View Encoded Claims</a>');
document.writeln('</li>');
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">View Processed Claims</a>');
document.writeln('</li>');
//generate documents
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">Generate Documents &rsaquo;&rsaquo;</a>');
document.writeln('<ul class="inner-nav">');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a" id="">CDMR</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a" id="">RFP</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a" id="">Transmittal Letter</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');
//view documents
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">View Documents &rsaquo;&rsaquo;</a>');
document.writeln('<ul class="inner-nav">');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a" id="">CDMR</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a" id="">RFP</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a" id="">Transmittal Letter</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');
//claims logging
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">Claims Logging &rsaquo;&rsaquo;</a>');
document.writeln('<ul class="inner-nav">');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a" id="">Encode Claim</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a" id="">View Claims Log</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');

document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');

/*-----------------------------------------------------------------------------------------------*/
/*                                         BILLBACK                                       */
/*-----------------------------------------------------------------------------------------------*/
document.writeln('<li id="main-nav-list">');
document.writeln('<img src="../icon/billback.png" height="20px" width="20px" style="vertical-align: middle;">');
document.writeln('<a href="#" id="main-nav-a" rel="personnel">Billback</a>');
document.writeln('<ul class="sub-nav">');
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">Billback</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');


/*-----------------------------------------------------------------------------------------------*/
/*                                         COLLECTION & CREDITING                                       */
/*-----------------------------------------------------------------------------------------------*/
document.writeln('<li id="main-nav-list">');
document.writeln('<img src="../icon/collection.png" height="20px" width="20px" style="vertical-align: middle;">');
document.writeln('<a href="#" id="main-nav-a" rel="personnel">Collection & Crediting</a>');
document.writeln('<ul class="sub-nav">');
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">Collection & Crediting</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');






///*-----------------------------------------------------------------------------------------------*/
///*                                         ADMIN                                      */
///*-----------------------------------------------------------------------------------------------*/
//document.writeln('<li id="main-nav-list">');
//document.writeln('<img src="../icon/admin.png" height="20px" width="20px" style="vertical-align: middle;">');
//document.writeln('<a href="#" id="main-nav-a" rel="personnel">Admin</a>');
////admin view policies
//document.writeln('<ul class="sub-nav">');
//document.writeln('<li id="sub-nav-list">');
//document.writeln('<a href="" id="sub-nav-a">View Policies &rsaquo;&rsaquo;</a>');
//document.writeln('<ul class="inner-nav">');
//document.writeln('<li id="sub-inner-list">');
//document.writeln('<a href="" id="internalsource" class="sub-inner-a">');
//document.writeln('New Accounts');
//document.writeln('</a>');
//document.writeln('</li>');
//document.writeln('<li id="sub-inner-list">');
//document.writeln('<a href="javascript:admin_accountsforrenewal()" class="sub-inner-a" id="accountsforrenewal">');
//document.writeln('Accounts for Renewal');
//document.writeln('</a>');
//document.writeln('</li>');
//document.writeln('<li id="sub-inner-list">');
//document.writeln('<a href="" class="sub-inner-a">View Policy</a>');
//document.writeln('</li>');
//document.writeln('</ul>');
//document.writeln('</li>');
//
////admin other endorsements
//document.writeln('<li id="sub-nav-list">');
//document.writeln('<a href="" id="sub-nav-a">Other Endorsements &rsaquo;&rsaquo;</a>');
//document.writeln('<ul class="inner-nav">');
//document.writeln('<li id="sub-inner-list">');
//document.writeln('<a href="javascript:admin_otherendorsements_cancel()" id="cancel" class="sub-inner-a">');
//document.writeln('Cancel Endorsement');
//document.writeln('</a>');
//document.writeln('</li>');
//document.writeln('<li id="sub-inner-list">');
//document.writeln('<a href="javascript:admin_otherendorsements_extend()" id="extend" class="sub-inner-a">');
//document.writeln('Extend Endorsement');
//document.writeln('</a>');
//document.writeln('</li>');
//document.writeln('</ul>');
//document.writeln('</li>');
//
////admin - member admin
//document.writeln('<li id="sub-nav-list">');
//document.writeln('<a href="" id="sub-nav-a">Member Admin &rsaquo;&rsaquo;</a>');
//document.writeln('<ul class="inner-nav">');
//document.writeln('<li id="sub-inner-list">');
//document.writeln('<a href="javascript:admin_newmember()" id="newmember" class="sub-inner-a">');
//document.writeln('New Member');
//document.writeln('</a>');
//document.writeln('</li>');
//document.writeln('<li id="sub-inner-list">');
//document.writeln('<a href="javascript:admin_batchupload()" id="batchupload" class="sub-inner-a">');
//document.writeln('Batch Upload Member');
//document.writeln('</a>');
//document.writeln('</li>');
//document.writeln('<li id="sub-inner-list">');
//document.writeln('<a href="" class="sub-inner-a">View Member</a>');
//document.writeln('</li>');
//document.writeln('<li id="sub-inner-list">');
//document.writeln('<a href="javascript:admin_cancellation()" id="cancellation" class="sub-inner-a">Cancellation of Member</a>');
//document.writeln('</li>');
//document.writeln('</ul>');
//document.writeln('</li>');
//
////admin-billing
//document.writeln('<li id="sub-nav-list">');
//document.writeln('<a href="" id="sub-nav-a">Billing &rsaquo;&rsaquo;</a>');
//document.writeln('<ul class="inner-nav">');
//document.writeln('<li id="sub-inner-list">');
//document.writeln('<a href="" id="internalsource" class="sub-inner-a">');
//document.writeln('Billing Information');
//document.writeln('</a>');
//document.writeln('</li>');
//document.writeln('<li id="sub-inner-list">');
//document.writeln('<a href="" id="internalsource" class="sub-inner-a">');
//document.writeln('Generate SOA');
//document.writeln('</a>');
//document.writeln('</li>');
//document.writeln('</ul>');
//document.writeln('</li>');
//
////id Issuance
//document.writeln('<li id="sub-nav-list">');
//document.writeln('<a href="" id="sub-nav-a">ID Issuance</a>');
//document.writeln('</li>');
//
//document.writeln('</ul>');
//document.writeln('</li>');


    

 
/*-----------------------------------------------------------------------------------------------*/
/*                                        HEALTH ASSIST                                      */
/*-----------------------------------------------------------------------------------------------*/
document.writeln('<li id="main-nav-list">');
document.writeln('<img src="../icon/healthassist.png" height="20px" width="20px" style="vertical-align: middle;">');
document.writeln('<a href="#" id="main-nav-a" rel="purchasing">Health Assist</a>');
//DENTAL HEALTH ASSIST
document.writeln('<ul class="sub-nav">');
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">Dental</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');

/*-----------------------------------------------------------------------------------------------*/
/*                                       REPORT                                     */
/*-----------------------------------------------------------------------------------------------*/
document.writeln('<li id="main-nav-list">');
document.writeln('<img src="../icon/healthassist.png" height="20px" width="20px" style="vertical-align: middle;">');
document.writeln('<a href="#" id="main-nav-a" rel="purchasing">Report</a>');
//DENTAL HEALTH ASSIST
document.writeln('<ul class="sub-nav">');
document.writeln('<li id="sub-nav-list">');
document.writeln('<a href="" id="sub-nav-a">Per Module &rsaquo;&rsaquo;</a>');
document.writeln('<ul class="inner-nav">');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a">MIS/IT</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a">Provier</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" id="" class="sub-inner-a">Marketing</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a">Hotline</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a">Collection and Crediting</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a">Claims</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a">Billback</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a">Admin</a>');
document.writeln('</li>');
document.writeln('<li id="sub-inner-list">');
document.writeln('<a href="" class="sub-inner-a">Healt Assist</a>');
document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');

document.writeln('</li>');
document.writeln('</ul>');
document.writeln('</li>');

document.writeln('</ul>');
document.writeln('</div>');

document.writeln('</div>');

//LOGOUT BAR
//document.writeln('<div class="logout_bar" style="float: right;">');
//document.writeln('<table>');
//document.writeln('<tr><td id="separator">Logged in as: Customer Service Representative </td>');
//document.writeln('<td id="separator">&nbsp;|&nbsp;</td>');
//document.writeln('<td><a href="">Logout&nbsp;&nbsp;</td>');
//document.writeln('</tr>');
//document.writeln('</table>');
//document.writeln('</div>');
//document.writeln('</div>');
