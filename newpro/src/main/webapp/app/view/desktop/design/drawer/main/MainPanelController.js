Ext.define('Newpro.view.desktop.design.drawer.main.MainPanelController', {
    extend: 'Ext.app.ViewController',
 
    alias: 'controller.mainPanel',
    
    onMainPanelAfterRender : function(mainPanel){
        if(mainPanel.userinfo && mainPanel.userinfo.hasOwnProperty('firstName')){
            var westPanel = Ext.getCmp('westPanel');
            var fullName = mainPanel.userinfo.firstName+' '+mainPanel.userinfo.lastName;
            westPanel.setTitle('<div><div style="font-size:16px;font-weight:bold;">'+fullName+'</div><div style="font-style:italic;font-size:12px;">'+mainPanel.userinfo.emailId+'</div></div>');
        }
        
        
       this.displayUserDetail();
        this.initializeGoogleMap();
        mainPanel.getEl().on('contextmenu', function(view) {
                       view.stopEvent();
        });
     
    },
    initializeGoogleMap : function(){
        var googleScript = document.createElement('script');
        googleScript.setAttribute("type","text/javascript");
        googleScript.setAttribute("src", "https://maps.googleapis.com/maps/api/js?v=3.18");
        document.body.appendChild(googleScript);
    },
    displayUserDetail:function()
    {
        //Get user cookie value set from angular js loginController
         var userNameDField =  Ext.getCmp('userNameDField');
        
        var cookieUserInfo = Ext.util.Cookies.get('userInfo');
        if(cookieUserInfo==null){
            var pathName=location.pathname;
            var initialPath=pathName.slice(0,pathName.lastIndexOf("/"));
            location.href=location.origin+initialPath+"/";
        }
        
        userNameDField.setValue(decodeURI(cookieUserInfo));
         
    
    },
    onDrawerBtnClick : function(drawerBtn){
        var westPanel = Ext.getCmp('westPanel');
        westPanel.setHidden(!westPanel.isHidden());
    },
    
    onMyProfileClick : function()
    {
        
         this.pushViewInMainTab( "Newpro.view.usermanagement.enduser.UserProfile","My Profile","menuAction","Newpro.view.usermanagement.enduser.UserProfile");
    },
    
    onChangePwdClick:function()
    {
      
         this.pushViewInMainTab( "Newpro.view.usermanagement.enduser.ChangePwd","Change Password","menuAction","Newpro.view.usermanagement.enduser.ChangePwd");
    },
     onCloudClick : function()
    {
        
        this.pushViewInMainTab("Newpro.view.clouddrive.CloudDrive","Cloud Drive","menuAction","Newpro.view.clouddrive.CloudDrive");
    },
    
    pushViewInMainTab : function(className,title,cmpKey,cmpValue){
        var appMainTabPanel = Ext.getCmp('appMainTabPanel');
        if(className){
        var ident= {};
          ident[cmpKey]=cmpValue;

         var appMainTabPanel =  Ext.getCmp('appMainTabPanel');
         var clickedAction = appMainTabPanel.down("["+cmpKey+"='"+cmpValue+"']");
         
         if(clickedAction){
            appMainTabPanel.setActiveItem(clickedAction);
            return clickedAction;
         }else{
        
         var addedForm = appMainTabPanel.add(Ext.create(className,{
             closable:true,
             title:title,
             menuAction:className,
             cmpKey:cmpValue
            
         }));
         Ext.merge(addedForm,ident);
         appMainTabPanel.setActiveItem(addedForm);
         return addedForm;
         }
     }
    },

    onLogoutClick : function(logoutBtn)
    {
        Ext.Ajax.request({
            url : "secure/Logout",
            method : 'POST',
            jsonData : {},
            success : function(response, scope) {
                
                var jsonRespone = Ext.JSON.decode(response.responseText);
                if (jsonRespone.response.success == "true") {
                    //this.location.reload();
                    var pathName=this.location.pathname;
                    var initialPath=pathName.slice(0,pathName.lastIndexOf("/"));
                    
                    Ext.util.Cookies.clear('changePwd',initialPath);
                    
                    this.location.href=this.location.origin+initialPath+"/";
                } else {
                    Ext.Msg.alert('Logout failed',jsonRespone.response.message);
                }
            },
            failure : function() {
                Ext.Msg.alert('Error', 'Cannot connect to server');
            }
        });
    },
    loadLangCombo : function(){

    
        Ext.Ajax.request({
            url : 'secure/SearchEngineService/getAvailableLanguages',
            method : 'GET',
            view : this.view,
            success : function(response, scope) {
                var responseData = Ext.decode(response.responseText);
                var data = Ext.decode(responseData.response.data.message);
                var combo = scope.view.down('#Lang');
                var store  = {
                    fields: [ {
                        name : 'name',
                        type : 'string'
                    }, {
                        name : 'value ',
                        type : 'string',
                    }],
                    data : data                 
                }
                combo.setStore(store);  
                combo.select(combo.getStore().getAt(0));
            },
            failure : function() {
                //Ext.Msg.alert('Error', 'Cannot connect to server');
            }
        });
     }
   
});
