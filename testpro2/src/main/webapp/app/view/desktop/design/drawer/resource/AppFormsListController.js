Ext.define('Testpro2.view.desktop.design.drawer.resource.AppFormsListController', {
    extend: 'Ext.app.ViewController',
 
    alias: 'controller.appFormsList',
    appFormsList:undefined,
    homeScreenMenuItem:undefined,
    init:function(){
    	this.appFormsList = this.getView();
    },
    onAppFormsListItemClick : function( sender, record, item, index, e, eOpts ){
        var nodedata = record.data;
        if(nodedata.menuId && nodedata.menuAction!==""){
        
         var appMainTabPanel =  Ext.getCmp('appMainTabPanel');
         var clickedAction = appMainTabPanel.down("[menuId='"+nodedata.menuId+"']");

         if(clickedAction){
            appMainTabPanel.setActiveItem(clickedAction);
         }else{


         var addedForm = appMainTabPanel.add(Ext.create(nodedata.menuAction,{
             closable:true,
             title:nodedata.menuName,
             menuId:nodedata.menuId,
        	 refId:nodedata.hasOwnProperty('refId')?nodedata.refId:""
         }));
         appMainTabPanel.setActiveItem(addedForm);
         }
     }
    },
    onDrawerBtnClick : function(drawerBtn){
        var westPanel = Ext.getCmp('westPanel');
        westPanel.setHidden(!westPanel.isHidden());
        var centerPanel = Ext.getCmp('centerPanel');
        centerPanel.setDisabled(!centerPanel.isDisabled());
          
    },
    onAppFormsListAfteRender : function(appFormsList){
       
        var sender = this;
        
        Ext.Ajax.request({
                     url : "secure/MenuService/findMainScreenMenus",
                     method:'POST', 
                     sender:sender,
                     jsonData:{
                     },
                     success : function(response,scope){
                          
                         var responseJson = Ext.JSON.decode(response.responseText);
                          
                          var data = Ext.decode(responseJson.response.data);
                          //scope.sender.loadAppFormsListStore(scope.sender,data.menus);
                          var menuRoot = scope.sender.view.getRootNode();
                          
                          scope.sender.configureAppMenu(scope.sender,menuRoot,data.menus,0);
                          
                          if(scope.sender.homeScreenMenuItem){
                              var appMainTabPanel =  Ext.getCmp('appMainTabPanel');
                              appMainTabPanel.removeAll(true);
                              appMainTabPanel.add(Ext.create(scope.sender.homeScreenMenuItem.menuAction));
                              
                              var centerPanel =  Ext.getCmp('centerPanel');
                              centerPanel.setTitle(scope.sender.homeScreenMenuItem.menuName);
                         
                          }
			if(data.homeScreenMenus) {
						try {
							var mainScreenDataList = data.homeScreenMenus;
							for(var i=0; i < mainScreenDataList.length; i++) {
								console.log("Menu-"+i +"-"+Ext.encode(mainScreenDataList[i]));
							}
						} catch(e) {	}
					}
					

                     },
                     failure : function(response,scope){
                       
                       Ext.MessageBox.show({title: 'Error',msg: "Cannot connect to server.",icon: Ext.MessageBox.ERROR});
                     }
                 },sender);     
    },
    configureAppMenu: function(scope,menunode,data,grouper){
        
          for (var i = 0; i <= data.length; i++) {
            var obj = data[i];
            if(obj){
                
                obj['menuGroupName'] = grouper;
                obj['expanded'] = true;
                obj['icon'] = 'none';
                
                obj['cls'] = grouper==0?"app-menu-tree-folder":obj.leaf?'app-menu-tree-leaf':'app-menu-tree-sub-folder';
                var addedNode = menunode.appendChild(obj);
                
                if(!scope.homeScreenMenuItem && (obj.menuCommands)){
                	var mCmd = Ext.decode(obj.menuCommands);
                	
                	if(mCmd.homeScreen && mCmd.homeScreen == true)
                	{
                		scope.homeScreenMenuItem = obj;
                	}
                }
                
                if(obj.children && obj.children.length>0){
                    scope.configureAppMenu(scope,addedNode,obj.children,obj.menuName);
                }
            }

            
          }

    },
    loadAppFormsListStore : function(scope,data,menuName){

        for (var i = 0; i <= data.length; i++) {
            var obj = data[i];
            if(obj){
            if(!obj.hasOwnProperty('children')){
            	obj['formGroupName']=menuName;
                scope.appFormsList.store.add(obj);
                
                if(!scope.homeScreenMenuItem && (obj.menuCommands)){
                	var mCmd = Ext.decode(obj.menuCommands);
                	
                	if(mCmd.homeScreen && mCmd.homeScreen == true)
                	{
                		scope.homeScreenMenuItem = obj;
                	}
                }
            }
            else if(obj.children && obj.children.length>0){
               scope.loadAppFormsListStore(scope,obj.children,obj.menuName);
            }
            }
        }
    }
});
