Ext.define('Testlic.testlic.web.com.view.testbc.testing.NameTestMain', {
     "xtype": "nameTestMainView",
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "NameTestMainController",
     "restURL": "/NameTest",
     "defaults": {
          "split": true
     },
     "requires": ["Testlic.testlic.shared.com.model.testbc.testing.NameTestModel", "Testlic.testlic.web.com.controller.testbc.testing.NameTestMainController", "Testlic.testlic.shared.com.viewmodel.testbc.testing.NameTestViewModel"],
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
               "displayName": "NameTest",
               "name": "NameTestTreeContainer",
               "itemId": "NameTestTreeContainer",
               "restURL": "/NameTest",
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
                    "itemId": "NameTestTree",
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
                    "displayName": "NameTest",
                    "title": "NameTest",
                    "name": "NameTest",
                    "itemId": "NameTestForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "tsid",
                         "itemId": "tsid",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "tsid",
                         "margin": "5 5 5 5",
                         "fieldLabel": "tsid<font color='red'> *<\/font>",
                         "fieldId": "5C8319CC-F090-461B-BC31-5C7E3F907D38",
                         "hidden": true,
                         "value": "",
                         "bindable": "tsid"
                    }, {
                         "name": "sName",
                         "itemId": "sName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "sName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "sName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F5C9B3CA-AF16-4BEF-A0F2-1DF078CF6162",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "sName",
                         "columnWidth": 0.5
                    }, {
                         "name": "sNo",
                         "itemId": "sNo",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "sNo",
                         "margin": "5 5 5 5",
                         "fieldLabel": "sNo<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "EB00F9FB-2078-4E7C-A0B6-B563E5DE8146",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "sNo",
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
                         "fieldId": "59F50997-001D-4DFB-B541-71AAABFEDFF2",
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
                         "customId": 905,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 905,
                              "customId": 967
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": 5,
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 905,
                              "customId": 968,
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
                              "parentId": 905,
                              "customId": 969,
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
                    "displayName": "NameTest",
                    "title": "Details Grid",
                    "name": "NameTestGrid",
                    "itemId": "NameTestGrid",
                    "restURL": "/NameTest",
                    "store": [],
                    "columns": [{
                         "header": "tsid",
                         "dataIndex": "tsid",
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
                         "header": "sName",
                         "dataIndex": "sName",
                         "flex": 1
                    }, {
                         "header": "sNo",
                         "dataIndex": "sNo",
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
               "displayName": "NameTest",
               "title": "NameTest",
               "name": "NameTest",
               "itemId": "NameTestForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "tsid",
                    "itemId": "tsid",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "tsid",
                    "margin": "5 5 5 5",
                    "fieldLabel": "tsid<font color='red'> *<\/font>",
                    "fieldId": "5C8319CC-F090-461B-BC31-5C7E3F907D38",
                    "hidden": true,
                    "value": "",
                    "bindable": "tsid"
               }, {
                    "name": "sName",
                    "itemId": "sName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "sName",
                    "margin": "5 5 5 5",
                    "fieldLabel": "sName<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F5C9B3CA-AF16-4BEF-A0F2-1DF078CF6162",
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "sName",
                    "columnWidth": 0.5
               }, {
                    "name": "sNo",
                    "itemId": "sNo",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "sNo",
                    "margin": "5 5 5 5",
                    "fieldLabel": "sNo<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "EB00F9FB-2078-4E7C-A0B6-B563E5DE8146",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "sNo",
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
                    "fieldId": "59F50997-001D-4DFB-B541-71AAABFEDFF2",
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
                    "customId": 905,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 905,
                         "customId": 967
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": 5,
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 905,
                         "customId": 968,
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
                         "parentId": 905,
                         "customId": 969,
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