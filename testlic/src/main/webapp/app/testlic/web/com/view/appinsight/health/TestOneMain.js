Ext.define('Testlic.testlic.web.com.view.appinsight.health.TestOneMain', {
     "xtype": "testOneMainView",
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestOneMainController",
     "restURL": "/TestOne",
     "defaults": {
          "split": true
     },
     "requires": ["Testlic.testlic.shared.com.model.appinsight.health.TestOneModel", "Testlic.testlic.web.com.controller.appinsight.health.TestOneMainController", "Testlic.testlic.shared.com.viewmodel.appinsight.health.TestOneViewModel"],
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
               "displayName": "TestOne",
               "name": "TestOneTreeContainer",
               "itemId": "TestOneTreeContainer",
               "restURL": "/TestOne",
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
                    "itemId": "TestOneTree",
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
                    "displayName": "TestOne",
                    "title": "TestOne",
                    "name": "TestOne",
                    "itemId": "TestOneForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "tid",
                         "itemId": "tid",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "tid",
                         "margin": "5 5 5 5",
                         "fieldLabel": "tid<font color='red'> *<\/font>",
                         "fieldId": "53DFAF55-53A3-4BB8-AF6F-EA0C4BE6AD5F",
                         "hidden": true,
                         "value": "",
                         "bindable": "tid"
                    }, {
                         "name": "aOne",
                         "itemId": "aOne",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "aOne",
                         "margin": "5 5 5 5",
                         "fieldLabel": "aOne<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "1EA31206-043B-4AD6-84E5-C287503ADDF2",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "aOne",
                         "columnWidth": 0.5
                    }, {
                         "name": "aTwo",
                         "itemId": "aTwo",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "aTwo",
                         "margin": "5 5 5 5",
                         "fieldLabel": "aTwo<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "11A1673F-FC34-44E7-A412-EB096D33BD29",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "aTwo",
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
                         "fieldId": "6D5FA5ED-2260-46FA-AD76-595D846B1164",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "total",
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
                         "fieldId": "A9C8C0A9-C706-4713-BBBC-6B7E5E38C8C8",
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
                         "customId": 109,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 109,
                              "customId": 178
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": 5,
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 109,
                              "customId": 179,
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
                              "parentId": 109,
                              "customId": 180,
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
                    "displayName": "TestOne",
                    "title": "Details Grid",
                    "name": "TestOneGrid",
                    "itemId": "TestOneGrid",
                    "restURL": "/TestOne",
                    "store": [],
                    "columns": [{
                         "header": "tid",
                         "dataIndex": "tid",
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
                         "header": "aOne",
                         "dataIndex": "aOne",
                         "flex": 1
                    }, {
                         "header": "aTwo",
                         "dataIndex": "aTwo",
                         "flex": 1
                    }, {
                         "header": "total",
                         "dataIndex": "total",
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
               "displayName": "TestOne",
               "title": "TestOne",
               "name": "TestOne",
               "itemId": "TestOneForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "tid",
                    "itemId": "tid",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "tid",
                    "margin": "5 5 5 5",
                    "fieldLabel": "tid<font color='red'> *<\/font>",
                    "fieldId": "53DFAF55-53A3-4BB8-AF6F-EA0C4BE6AD5F",
                    "hidden": true,
                    "value": "",
                    "bindable": "tid"
               }, {
                    "name": "aOne",
                    "itemId": "aOne",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "aOne",
                    "margin": "5 5 5 5",
                    "fieldLabel": "aOne<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "1EA31206-043B-4AD6-84E5-C287503ADDF2",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "aOne",
                    "columnWidth": 0.5
               }, {
                    "name": "aTwo",
                    "itemId": "aTwo",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "aTwo",
                    "margin": "5 5 5 5",
                    "fieldLabel": "aTwo<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "11A1673F-FC34-44E7-A412-EB096D33BD29",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "aTwo",
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
                    "fieldId": "6D5FA5ED-2260-46FA-AD76-595D846B1164",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "total",
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
                    "fieldId": "A9C8C0A9-C706-4713-BBBC-6B7E5E38C8C8",
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
                    "customId": 109,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 109,
                         "customId": 178
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": 5,
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 109,
                         "customId": 179,
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
                         "parentId": 109,
                         "customId": 180,
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