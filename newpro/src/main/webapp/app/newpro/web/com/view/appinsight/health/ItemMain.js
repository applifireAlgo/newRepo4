Ext.define('Newpro.newpro.web.com.view.appinsight.health.ItemMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ItemMainController",
     "restURL": "/Item",
     "defaults": {
          "split": true
     },
     "requires": ["Newpro.newpro.shared.com.model.appinsight.health.ItemModel", "Newpro.newpro.web.com.controller.appinsight.health.ItemMainController", "Newpro.newpro.shared.com.model.appinsight.health.BrandsModel", "Newpro.newpro.shared.com.model.appinsight.health.CategoryModel", "Newpro.newpro.shared.com.viewmodel.appinsight.health.ItemViewModel"],
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
               "displayName": "Item",
               "name": "ItemTreeContainer",
               "itemId": "ItemTreeContainer",
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
                    "itemId": "ItemTree",
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
                    "displayName": "Item",
                    "name": "Item",
                    "itemId": "ItemForm",
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
                                   "name": "itemId",
                                   "itemId": "itemId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "itemId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "itemId<font color='red'> *<\/font>",
                                   "fieldId": "094264CE-618B-46CB-8FC1-44859FB8A0FC",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "itemId"
                              }, {
                                   "name": "itemname",
                                   "itemId": "itemname",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "itemname",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "itemname<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "5DC25E41-F7BA-4C21-AE61-901A9815B0F6",
                                   "minLength": "1",
                                   "maxLength": "256",
                                   "bindable": "itemname",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "brandnm",
                                   "itemId": "brandnm",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "brandnm",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Newpro.newpro.shared.com.model.appinsight.health.BrandsModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "brandnm<font color='red'> *<\/font>",
                                   "fieldId": "1BFBC5A2-7ECF-4D36-AA02-326C0A70DA97",
                                   "restURL": "Brands",
                                   "bindable": "brandnm",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onBrandnmChange"
                                   }
                              }, {
                                   "name": "categorynm",
                                   "itemId": "categorynm",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "categorynm",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Newpro.newpro.shared.com.model.appinsight.health.CategoryModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "categorynm<font color='red'> *<\/font>",
                                   "fieldId": "420D376F-5040-4CCC-B8F8-85576EC307D8",
                                   "restURL": "Category",
                                   "bindable": "categorynm",
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
                                   "fieldId": "5A3FF6D5-8EF0-461C-B25F-9F3A5EBB13BA",
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
                    "displayName": "Item",
                    "title": "Details Grid",
                    "name": "ItemGrid",
                    "itemId": "ItemGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "itemId",
                         "dataIndex": "itemId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "itemname",
                         "dataIndex": "itemname",
                         "flex": 1
                    }, {
                         "header": "brandnm",
                         "dataIndex": "brandnm",
                         "flex": 1
                    }, {
                         "header": "categorynm",
                         "dataIndex": "categorynm",
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
               "displayName": "Item",
               "name": "Item",
               "itemId": "ItemForm",
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
                              "name": "itemId",
                              "itemId": "itemId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "itemId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "itemId<font color='red'> *<\/font>",
                              "fieldId": "094264CE-618B-46CB-8FC1-44859FB8A0FC",
                              "hidden": true,
                              "value": "",
                              "bindable": "itemId"
                         }, {
                              "name": "itemname",
                              "itemId": "itemname",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "itemname",
                              "margin": "5 5 5 5",
                              "fieldLabel": "itemname<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "5DC25E41-F7BA-4C21-AE61-901A9815B0F6",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "itemname",
                              "columnWidth": 0.5
                         }, {
                              "name": "brandnm",
                              "itemId": "brandnm",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "brandnm",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Newpro.newpro.shared.com.model.appinsight.health.BrandsModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "brandnm<font color='red'> *<\/font>",
                              "fieldId": "1BFBC5A2-7ECF-4D36-AA02-326C0A70DA97",
                              "restURL": "Brands",
                              "bindable": "brandnm",
                              "columnWidth": 0.5,
                              "listeners": {
                                   "change": "onBrandnmChange"
                              }
                         }, {
                              "name": "categorynm",
                              "itemId": "categorynm",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "categorynm",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Newpro.newpro.shared.com.model.appinsight.health.CategoryModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "categorynm<font color='red'> *<\/font>",
                              "fieldId": "420D376F-5040-4CCC-B8F8-85576EC307D8",
                              "restURL": "Category",
                              "bindable": "categorynm",
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
                              "fieldId": "5A3FF6D5-8EF0-461C-B25F-9F3A5EBB13BA",
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