Ext.define('Testpro2.view.desktop.design.menubar.main.MainPanel', {
    extend : 'Ext.panel.Panel',
    xtype : 'mainPanel',
    requires : ['Testpro2.view.desktop.design.menubar.main.MainPanelController','Testpro2.view.desktop.design.menubar.menu.AppMenuBar'],
    userinfo:{},
    id:'mainPanel',
    controller:'mainPanel',
   
    layout: {
        type: 'border'
    },

    items: [
            {
                 region : 'center',
                 xtype:'tabpanel',
                 title:'',
                 id:'appMainTabPanel',
                 itemId:'appMainTabPanel',
                 tabBar:{
                            defaults:{
                                height:30
                            },
                            style:{
                                background:"#ffffff"
                            }
                },
                title:'',
                layout:'fit',
                style:{
                    background:"#ffffff"
                },
                header:{
                         titlePosition:1,
                         style:"box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23);",
                         items:[{
                            xtype:'appMenuBar'
                         }],
                          tools:[{
                            xtype:'textfield',
                            id:"searchField",
                            itemId:'searchField',
                            emptyText:'Search',
                            margin:'0 5 0 5',
                            width:'10%',
                            height:38,
                            hidden:false
                           
                            
                         },{
                             xtype: 'button',
                             text:'',
                             itemId:'searchBtn',
                             margin:'0 5 0 5',
                             scale:'large',
                             hidden:false,
                             isMice:false,
                             style:{
                                  borderWidth:'0px',
                                  borderRadius:'50%'
                             },
                             icon:'resources/appicons/ic_search.png',
                             listeners : {
                                click : 'onSearchClick'
                             }
                             
                          },{
                             xtype: 'button',
                             text:'',
                             itemId:'voice',
                             margin:'0 5 0 5',
                             scale:'large',
                             isMice:true,
                             hidden:false,
                             style:{
                                  borderWidth:'0px',
                                  borderRadius:'50%'
                             },
                             icon:'resources/appicons/ic_mic.png',
                            listeners:{
                                click:'onVoiceSearchClick'
                             }
                             
                          },{
                            xtype: 'button',
                            text:'',
                            scale:'large',
                            arrowVisible:false,
                            margin:'0 0 0 5',
                            style:{
                                  borderWidth:'0px',
                                  borderRadius:'50%'
                               },
                            icon:'resources/appicons/ic_user_settings.png',
                            arrowAlign:'bottom',
                            listeners : {mouseover : function() { this.menu.showBy(this); } },
                            menu:{
                                items : [
                                                            {
                                                                xtype : 'menuitem',
                                                                height : 38,
                                                                text : 'My Profile',
                                                                icon : 'images/menu/myprofile.png',
                                                                listeners : {
                                                                    click : 'onMyProfileClick'
                                                                }
                                                            },
                                                            {
                                                                xtype : 'menuitem',
                                                                height : 38,
                                                                text : 'Change Password',
                                                                icon : 'images/menu/pwdReset.png',
                                                                listeners : {
                                                                    click : 'onChangePwdClick'
                                                                }
                                                            },
                                                            {
                                                                xtype : 'menuitem',
                                                                height : 38,
                                                                text : 'Cloud Drive',
                                                                disabled : true,
                                                                icon : 'images/menu/clouddrive.png',
                                                                listeners : {
                                                                    click : 'onCloudClick'
                                                                }
                                                            },
                                                            {
                                                                xtype : 'menuitem',
                                                                height : 38,
                                                                text : 'Log Out',
                                                                icon : 'images/menu/logout.png',
                                                                listeners : {
                                                                    click : 'onLogoutClick'
                                                                }
                                                            }]
                            }
                         }]
                         
                         
                }
                

            }
    ],
    listeners:{
        afterrender:'onMainPanelAfterRender'
    }

});
