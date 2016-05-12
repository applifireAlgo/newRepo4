Ext.define('Testpro2.testpro2.web.com.view.appinsight.health.TestTwoMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestTwoMainController",
     "restURL": "/TestTwo",
     "defaults": {
          "split": true
     },
     "requires": ["Testpro2.testpro2.shared.com.model.appinsight.health.TestTwoModel", "Testpro2.testpro2.web.com.controller.appinsight.health.TestTwoMainController", "Testpro2.testpro2.shared.com.viewmodel.appinsight.health.TestTwoViewModel"],
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
               "displayName": "TestTwo",
               "name": "TestTwoTreeContainer",
               "itemId": "TestTwoTreeContainer",
               "restURL": "/TestTwo",
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
                    "itemId": "TestTwoTree",
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
                    "displayName": "TestTwo",
                    "title": "TestTwo",
                    "name": "TestTwo",
                    "itemId": "TestTwoForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "tod",
                         "itemId": "tod",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "tod",
                         "margin": "5 5 5 5",
                         "fieldLabel": "tod<font color='red'> *<\/font>",
                         "fieldId": "7A129F3F-B969-45A3-922E-54C4481EC7A9",
                         "hidden": true,
                         "value": "",
                         "bindable": "tod"
                    }, {
                         "name": "tnm",
                         "itemId": "tnm",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "tnm",
                         "margin": "5 5 5 5",
                         "fieldLabel": "tnm<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "FD3B8FA1-2777-4720-A604-785B404AE581",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "tnm",
                         "columnWidth": 0.5
                    }, {
                         "name": "tno",
                         "itemId": "tno",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "tno",
                         "margin": "5 5 5 5",
                         "fieldLabel": "tno<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "1A787F70-1912-4373-91A3-2B05AC180024",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "tno",
                         "columnWidth": 0.5
                    }, {
                         "name": "tpp",
                         "itemId": "tpp",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "tpp",
                         "margin": "5 5 5 5",
                         "inputValue": true,
                         "fieldLabel": "tpp",
                         "fieldId": "EF86EFBF-8D17-4110-AE82-45AE0F49C72C",
                         "bindable": "tpp",
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
                         "fieldId": "8B492548-8B62-4903-B9DC-AC9FC5710D45",
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
                         "customId": 284,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 284,
                              "customId": 253
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 284,
                              "customId": 254,
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
                              "parentId": 284,
                              "customId": 255,
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
                    "displayName": "TestTwo",
                    "title": "Details Grid",
                    "name": "TestTwoGrid",
                    "itemId": "TestTwoGrid",
                    "restURL": "/TestTwo",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "tod",
                         "dataIndex": "tod",
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
                         "header": "tnm",
                         "dataIndex": "tnm",
                         "flex": 1
                    }, {
                         "header": "tno",
                         "dataIndex": "tno",
                         "flex": 1
                    }, {
                         "header": "tpp",
                         "dataIndex": "tpp",
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
               "displayName": "TestTwo",
               "title": "TestTwo",
               "name": "TestTwo",
               "itemId": "TestTwoForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "tod",
                    "itemId": "tod",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "tod",
                    "margin": "5 5 5 5",
                    "fieldLabel": "tod<font color='red'> *<\/font>",
                    "fieldId": "7A129F3F-B969-45A3-922E-54C4481EC7A9",
                    "hidden": true,
                    "value": "",
                    "bindable": "tod"
               }, {
                    "name": "tnm",
                    "itemId": "tnm",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "tnm",
                    "margin": "5 5 5 5",
                    "fieldLabel": "tnm<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "FD3B8FA1-2777-4720-A604-785B404AE581",
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "tnm",
                    "columnWidth": 0.5
               }, {
                    "name": "tno",
                    "itemId": "tno",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "tno",
                    "margin": "5 5 5 5",
                    "fieldLabel": "tno<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "1A787F70-1912-4373-91A3-2B05AC180024",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "tno",
                    "columnWidth": 0.5
               }, {
                    "name": "tpp",
                    "itemId": "tpp",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "tpp",
                    "margin": "5 5 5 5",
                    "inputValue": true,
                    "fieldLabel": "tpp",
                    "fieldId": "EF86EFBF-8D17-4110-AE82-45AE0F49C72C",
                    "bindable": "tpp",
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
                    "fieldId": "8B492548-8B62-4903-B9DC-AC9FC5710D45",
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
                    "customId": 284,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 284,
                         "customId": 253
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 284,
                         "customId": 254,
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
                         "parentId": 284,
                         "customId": 255,
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