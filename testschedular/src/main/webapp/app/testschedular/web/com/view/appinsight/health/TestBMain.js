Ext.define('Testschedular.testschedular.web.com.view.appinsight.health.TestBMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestBMainController",
     "restURL": "/TestB",
     "defaults": {
          "split": true
     },
     "requires": ["Testschedular.testschedular.shared.com.model.appinsight.health.TestBModel", "Testschedular.testschedular.web.com.controller.appinsight.health.TestBMainController", "Testschedular.testschedular.shared.com.viewmodel.appinsight.health.TestBViewModel"],
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
               "displayName": "TestB",
               "name": "TestBTreeContainer",
               "itemId": "TestBTreeContainer",
               "restURL": "/TestB",
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
                    "itemId": "TestBTree",
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
                    "customWidgetType": "vdFormpanel",
                    "xtype": "form",
                    "displayName": "TestB",
                    "title": "TestB",
                    "name": "TestB",
                    "itemId": "TestBForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "aid",
                         "itemId": "aid",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "aid",
                         "margin": "5 5 5 5",
                         "fieldLabel": "aid<font color='red'> *<\/font>",
                         "fieldId": "4C258537-F4F2-4FD5-9E6D-B52E66A5A271",
                         "hidden": true,
                         "value": "",
                         "bindable": "aid"
                    }, {
                         "name": "anm",
                         "itemId": "anm",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "anm",
                         "margin": "5 5 5 5",
                         "fieldLabel": "anm<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "0AB2E5FD-176F-4230-ACD4-E5CC36E2E337",
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
                         "fieldId": "AEE242C0-6089-4584-98FF-353DB8B57D96",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "ano",
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
                         "fieldId": "542B5804-2C72-4D60-9D2D-9C9EC7A71F10",
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
                         "isToolBar": true,
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 194,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 194,
                              "customId": 789
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": 5,
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 194,
                              "customId": 790,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "resetFormButton",
                              "margin": 5,
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 194,
                              "customId": 791,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }]
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
                    "displayName": "TestB",
                    "title": "Details Grid",
                    "name": "TestBGrid",
                    "itemId": "TestBGrid",
                    "restURL": "/TestB",
                    "store": [],
                    "columns": [{
                         "header": "aid",
                         "dataIndex": "aid",
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
               "displayName": "TestB",
               "title": "TestB",
               "name": "TestB",
               "itemId": "TestBForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "aid",
                    "itemId": "aid",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "aid",
                    "margin": "5 5 5 5",
                    "fieldLabel": "aid<font color='red'> *<\/font>",
                    "fieldId": "4C258537-F4F2-4FD5-9E6D-B52E66A5A271",
                    "hidden": true,
                    "value": "",
                    "bindable": "aid"
               }, {
                    "name": "anm",
                    "itemId": "anm",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "anm",
                    "margin": "5 5 5 5",
                    "fieldLabel": "anm<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "0AB2E5FD-176F-4230-ACD4-E5CC36E2E337",
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
                    "fieldId": "AEE242C0-6089-4584-98FF-353DB8B57D96",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "ano",
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
                    "fieldId": "542B5804-2C72-4D60-9D2D-9C9EC7A71F10",
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
                    "isToolBar": true,
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 194,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 194,
                         "customId": 789
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": 5,
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 194,
                         "customId": 790,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "resetFormButton",
                         "margin": 5,
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 194,
                         "customId": 791,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }]
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