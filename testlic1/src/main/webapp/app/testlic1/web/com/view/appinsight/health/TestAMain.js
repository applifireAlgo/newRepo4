Ext.define('Testlic1.testlic1.web.com.view.appinsight.health.TestAMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestAMainController",
     "restURL": "/TestA",
     "defaults": {
          "split": true
     },
     "requires": ["Testlic1.testlic1.shared.com.model.appinsight.health.TestAModel", "Testlic1.testlic1.web.com.controller.appinsight.health.TestAMainController", "Testlic1.testlic1.shared.com.viewmodel.appinsight.health.TestAViewModel"],
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
               "displayName": "TestA",
               "name": "TestATreeContainer",
               "itemId": "TestATreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "name": "entityTreePanel",
                    "title": "Browse",
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
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
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
                    "xtype": "form",
                    "displayName": "TestA",
                    "name": "TestA",
                    "itemId": "TestAForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "aid",
                                   "itemId": "aid",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "aid",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "aid<font color='red'> *<\/font>",
                                   "fieldId": "2291857A-9CC3-4389-90E2-2904993B1BE8",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "aid"
                              }, {
                                   "name": "anm",
                                   "itemId": "anm",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C1243C8E-FC05-4830-8DBF-3B0F28371A1B",
                                   "minLength": "1",
                                   "maxLength": "256",
                                   "bindable": "anm",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "ano",
                                   "itemId": "ano",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Number",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Number<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "39823708-5CF7-4C08-8FB0-14B8E208394F",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "bindable": "ano",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "total",
                                   "itemId": "total",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "total",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "total<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "4FDCBCBB-5A23-4F4A-8E88-8610F7DAFA19",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "bindable": "total",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "ano1",
                                   "itemId": "ano1",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "ano1",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "ano1<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "0DE2E1FC-A78A-4C23-A47C-869300544677",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "bindable": "ano1",
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
                                   "fieldId": "B8F51C97-ABAF-42B3-A3D8-3CE4930E3F70",
                                   "bindable": "versionId",
                                   "hidden": true
                              }]
                         }]
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }],
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "TestA",
                    "title": "Details Grid",
                    "name": "TestAGrid",
                    "itemId": "TestAGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "aid",
                         "dataIndex": "aid",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Name",
                         "dataIndex": "anm",
                         "flex": 1
                    }, {
                         "header": "Number",
                         "dataIndex": "ano",
                         "flex": 1
                    }, {
                         "header": "total",
                         "dataIndex": "total",
                         "flex": 1
                    }, {
                         "header": "ano1",
                         "dataIndex": "ano1",
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
               "xtype": "form",
               "displayName": "TestA",
               "name": "TestA",
               "itemId": "TestAForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "aid",
                              "itemId": "aid",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "aid",
                              "margin": "5 5 5 5",
                              "fieldLabel": "aid<font color='red'> *<\/font>",
                              "fieldId": "2291857A-9CC3-4389-90E2-2904993B1BE8",
                              "hidden": true,
                              "value": "",
                              "bindable": "aid"
                         }, {
                              "name": "anm",
                              "itemId": "anm",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "C1243C8E-FC05-4830-8DBF-3B0F28371A1B",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "anm",
                              "columnWidth": 0.5
                         }, {
                              "name": "ano",
                              "itemId": "ano",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Number",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Number<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "39823708-5CF7-4C08-8FB0-14B8E208394F",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "bindable": "ano",
                              "columnWidth": 0.5
                         }, {
                              "name": "total",
                              "itemId": "total",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "total",
                              "margin": "5 5 5 5",
                              "fieldLabel": "total<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "4FDCBCBB-5A23-4F4A-8E88-8610F7DAFA19",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "bindable": "total",
                              "columnWidth": 0.5
                         }, {
                              "name": "ano1",
                              "itemId": "ano1",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "ano1",
                              "margin": "5 5 5 5",
                              "fieldLabel": "ano1<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "0DE2E1FC-A78A-4C23-A47C-869300544677",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "bindable": "ano1",
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
                              "fieldId": "B8F51C97-ABAF-42B3-A3D8-3CE4930E3F70",
                              "bindable": "versionId",
                              "hidden": true
                         }]
                    }]
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }],
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});