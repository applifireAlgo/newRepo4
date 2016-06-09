Ext.define('Newpro.newpro.web.com.view.appinsight.health.CategoryMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CategoryMainController",
     "restURL": "/Category",
     "defaults": {
          "split": true
     },
     "requires": ["Newpro.newpro.shared.com.model.appinsight.health.CategoryModel", "Newpro.newpro.web.com.controller.appinsight.health.CategoryMainController", "Newpro.newpro.shared.com.model.appinsight.health.BrandsModel", "Newpro.newpro.shared.com.viewmodel.appinsight.health.CategoryViewModel"],
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
               "displayName": "Category",
               "name": "CategoryTreeContainer",
               "itemId": "CategoryTreeContainer",
               "restURL": "/Category",
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
                    "itemId": "CategoryTree",
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
                    "displayName": "Category",
                    "title": "Category",
                    "name": "Category",
                    "itemId": "CategoryForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "cid",
                         "itemId": "cid",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "cid",
                         "margin": "5 5 5 5",
                         "fieldLabel": "cid<font color='red'> *<\/font>",
                         "fieldId": "C1D830BB-2D08-410A-BD2D-CAF9E26C9AE3",
                         "hidden": true,
                         "value": "",
                         "bindable": "cid"
                    }, {
                         "name": "categorynm",
                         "itemId": "categorynm",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "categorynm",
                         "margin": "5 5 5 5",
                         "fieldLabel": "categorynm<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "5CB6AEB1-50B3-442C-85D4-E979F04CC6BC",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "categorynm",
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
                         "fieldId": "4ECA1B4B-CCD5-48F4-9209-C0BA63CD1056",
                         "restURL": "Brands",
                         "bindable": "brandnm",
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
                         "fieldId": "C00B5BA9-418A-44F7-9B91-B494A0F587FB",
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
                         "customId": 794,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 794,
                              "customId": 832
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 794,
                              "customId": 833,
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
                              "parentId": 794,
                              "customId": 834,
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
                    "displayName": "Category",
                    "title": "Details Grid",
                    "name": "CategoryGrid",
                    "itemId": "CategoryGrid",
                    "restURL": "/Category",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "cid",
                         "dataIndex": "cid",
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
                         "header": "categorynm",
                         "dataIndex": "categorynm",
                         "flex": 1
                    }, {
                         "header": "brandnm",
                         "dataIndex": "brandnm",
                         "renderer": "renderFormValue",
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
               "displayName": "Category",
               "title": "Category",
               "name": "Category",
               "itemId": "CategoryForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "cid",
                    "itemId": "cid",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "cid",
                    "margin": "5 5 5 5",
                    "fieldLabel": "cid<font color='red'> *<\/font>",
                    "fieldId": "C1D830BB-2D08-410A-BD2D-CAF9E26C9AE3",
                    "hidden": true,
                    "value": "",
                    "bindable": "cid"
               }, {
                    "name": "categorynm",
                    "itemId": "categorynm",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "categorynm",
                    "margin": "5 5 5 5",
                    "fieldLabel": "categorynm<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "5CB6AEB1-50B3-442C-85D4-E979F04CC6BC",
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "categorynm",
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
                    "fieldId": "4ECA1B4B-CCD5-48F4-9209-C0BA63CD1056",
                    "restURL": "Brands",
                    "bindable": "brandnm",
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
                    "fieldId": "C00B5BA9-418A-44F7-9B91-B494A0F587FB",
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
                    "customId": 794,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 794,
                         "customId": 832
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 794,
                         "customId": 833,
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
                         "parentId": 794,
                         "customId": 834,
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