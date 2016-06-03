Ext.define('Testaone.testaone.web.com.view.appinsight.health.EmpMain', {
     "xtype": "emp",
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "EmpMainController",
     "restURL": "/Emp",
     "defaults": {
          "split": true
     },
     "requires": ["Testaone.testaone.shared.com.model.appinsight.health.EmpModel", "Testaone.testaone.web.com.controller.appinsight.health.EmpMainController", "Testaone.view.fw.component.DateTimeField", "Testaone.view.fw.component.DateTimePicker", "Testaone.testaone.shared.com.viewmodel.appinsight.health.EmpViewModel"],
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
               "displayName": "Emp",
               "name": "EmpTreeContainer",
               "itemId": "EmpTreeContainer",
               "restURL": "/Emp",
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
                    "itemId": "EmpTree",
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
                    "displayName": "Emp",
                    "title": "Emp",
                    "name": "Emp",
                    "itemId": "EmpForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "empId",
                         "itemId": "empId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "empId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "empId<font color='red'> *<\/font>",
                         "fieldId": "8CB4BF5D-8B9E-4005-82AC-C44DFF326243",
                         "hidden": true,
                         "value": "",
                         "bindable": "empId"
                    }, {
                         "name": "empName",
                         "itemId": "empName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "empName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "empName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "C80CB419-BE7B-4B1B-82D5-4C9E616D644A",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "empName",
                         "columnWidth": 0.5
                    }, {
                         "name": "dob",
                         "itemId": "dob",
                         "xtype": "customdatetimefield",
                         "customWidgetType": "customdatetimefield",
                         "displayName": "dob",
                         "margin": "5 5 5 5",
                         "submitFormat": "d-m-Y H:i:s",
                         "format": "d-m-Y H:i:s",
                         "fieldLabel": "dob<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "EF3B943E-0FDA-4799-9EC4-D8FD02EE1277",
                         "bindable": "dob",
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
                         "fieldId": "2185D823-A903-48D9-AD90-094B6BE556E2",
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
                         "customId": 323,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 323,
                              "customId": 731
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": 5,
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 323,
                              "customId": 732,
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
                              "parentId": 323,
                              "customId": 733,
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
                    "displayName": "Emp",
                    "title": "Details Grid",
                    "name": "EmpGrid",
                    "itemId": "EmpGrid",
                    "restURL": "/Emp",
                    "store": [],
                    "columns": [{
                         "header": "empId",
                         "dataIndex": "empId",
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
                         "header": "empName",
                         "dataIndex": "empName",
                         "flex": 1
                    }, {
                         "header": "dob",
                         "dataIndex": "dob",
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
               "displayName": "Emp",
               "title": "Emp",
               "name": "Emp",
               "itemId": "EmpForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "empId",
                    "itemId": "empId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "empId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "empId<font color='red'> *<\/font>",
                    "fieldId": "8CB4BF5D-8B9E-4005-82AC-C44DFF326243",
                    "hidden": true,
                    "value": "",
                    "bindable": "empId"
               }, {
                    "name": "empName",
                    "itemId": "empName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "empName",
                    "margin": "5 5 5 5",
                    "fieldLabel": "empName<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "C80CB419-BE7B-4B1B-82D5-4C9E616D644A",
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "empName",
                    "columnWidth": 0.5
               }, {
                    "name": "dob",
                    "itemId": "dob",
                    "xtype": "customdatetimefield",
                    "customWidgetType": "customdatetimefield",
                    "displayName": "dob",
                    "margin": "5 5 5 5",
                    "submitFormat": "d-m-Y H:i:s",
                    "format": "d-m-Y H:i:s",
                    "fieldLabel": "dob<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "EF3B943E-0FDA-4799-9EC4-D8FD02EE1277",
                    "bindable": "dob",
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
                    "fieldId": "2185D823-A903-48D9-AD90-094B6BE556E2",
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
                    "customId": 323,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 323,
                         "customId": 731
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": 5,
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 323,
                         "customId": 732,
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
                         "parentId": 323,
                         "customId": 733,
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