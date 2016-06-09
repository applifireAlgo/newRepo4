Ext.define('Newpro.newpro.web.com.view.appinsight.health.TestAMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestAMainController",
     "restURL": "/TestA",
     "defaults": {
          "split": true
     },
     "requires": ["Newpro.newpro.shared.com.model.appinsight.health.TestAModel", "Newpro.newpro.web.com.controller.appinsight.health.TestAMainController", "Newpro.view.fw.component.DateTimeField", "Newpro.view.fw.component.DateTimePicker", "Newpro.newpro.shared.com.viewmodel.appinsight.health.TestAViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "TestA",
               "name": "TestATreeContainer",
               "itemId": "TestATreeContainer",
               "restURL": "/TestA",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "name": "entityTreePanel",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "TestATree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "name": "filterButton",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "xtype": "form",
                    "displayName": "TestA",
                    "title": "TestA",
                    "name": "TestA",
                    "itemId": "TestAForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "aa",
                         "itemId": "aa",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "aa",
                         "margin": "5 5 5 5",
                         "fieldLabel": "aa<font color='red'> *<\/font>",
                         "fieldId": "8A51B5FB-1BD6-474A-8480-4A34E9EF34FF",
                         "hidden": true,
                         "value": "",
                         "bindable": "aa"
                    }, {
                         "name": "anm",
                         "itemId": "anm",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "anm",
                         "margin": "5 5 5 5",
                         "fieldLabel": "anm<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "13A80DB9-24EC-476B-9CCC-EE6C941A50DA",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "anm",
                         "columnWidth": 0.5
                    }, {
                         "name": "ano",
                         "itemId": "ano",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "ano",
                         "margin": "5 5 5 5",
                         "fieldLabel": "ano<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "BB5BA618-C96A-4034-9CCE-100E039CA618",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "ano",
                         "columnWidth": 0.5
                    }, {
                         "name": "aDate",
                         "itemId": "aDate",
                         "xtype": "customdatetimefield",
                         "customWidgetType": "vdCustomDateTime",
                         "displayName": "aDate",
                         "margin": "5 5 5 5",
                         "submitFormat": "d-m-Y H:i:s",
                         "format": "d-m-Y H:i:s",
                         "fieldLabel": "aDate<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "5C382958-766D-4A25-B61A-A7C587DD693E",
                         "bindable": "aDate",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "516DA5E5-1247-4957-86D6-104407868B44",
                         "bindable": "versionId",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 747,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 747,
                              "customId": 454
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 747,
                              "customId": 455,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "resetFormButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 747,
                              "customId": 456,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "TestA",
                    "title": "Details Grid",
                    "name": "TestAGrid",
                    "itemId": "TestAGrid",
                    "restURL": "/TestA",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "aa",
                         "dataIndex": "aa",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "anm",
                         "dataIndex": "anm",
                         "flex": 1
                    }, {
                         "header": "ano",
                         "dataIndex": "ano",
                         "flex": 1
                    }, {
                         "header": "aDate",
                         "dataIndex": "aDate",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "xtype": "form",
               "displayName": "TestA",
               "title": "TestA",
               "name": "TestA",
               "itemId": "TestAForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "aa",
                    "itemId": "aa",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "aa",
                    "margin": "5 5 5 5",
                    "fieldLabel": "aa<font color='red'> *<\/font>",
                    "fieldId": "8A51B5FB-1BD6-474A-8480-4A34E9EF34FF",
                    "hidden": true,
                    "value": "",
                    "bindable": "aa"
               }, {
                    "name": "anm",
                    "itemId": "anm",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "anm",
                    "margin": "5 5 5 5",
                    "fieldLabel": "anm<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "13A80DB9-24EC-476B-9CCC-EE6C941A50DA",
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "anm",
                    "columnWidth": 0.5
               }, {
                    "name": "ano",
                    "itemId": "ano",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "ano",
                    "margin": "5 5 5 5",
                    "fieldLabel": "ano<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "BB5BA618-C96A-4034-9CCE-100E039CA618",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "ano",
                    "columnWidth": 0.5
               }, {
                    "name": "aDate",
                    "itemId": "aDate",
                    "xtype": "customdatetimefield",
                    "customWidgetType": "vdCustomDateTime",
                    "displayName": "aDate",
                    "margin": "5 5 5 5",
                    "submitFormat": "d-m-Y H:i:s",
                    "format": "d-m-Y H:i:s",
                    "fieldLabel": "aDate<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "5C382958-766D-4A25-B61A-A7C587DD693E",
                    "bindable": "aDate",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "516DA5E5-1247-4957-86D6-104407868B44",
                    "bindable": "versionId",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 747,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 747,
                         "customId": 454
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 747,
                         "customId": 455,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "resetFormButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 747,
                         "customId": 456,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});