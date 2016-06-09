Ext.define('Testpro2.testpro2.web.com.view.organization.locationmanagement.LanguageMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "LanguageMainController",
     "restURL": "/Language",
     "defaults": {
          "split": true
     },
     "requires": ["Testpro2.testpro2.shared.com.model.organization.locationmanagement.LanguageModel", "Testpro2.testpro2.web.com.controller.organization.locationmanagement.LanguageMainController", "Testpro2.testpro2.shared.com.viewmodel.organization.locationmanagement.LanguageViewModel"],
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
               "displayName": "Language",
               "name": "LanguageTreeContainer",
               "itemId": "LanguageTreeContainer",
               "restURL": "/Language",
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
                    "itemId": "LanguageTree",
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
                    "displayName": "Language",
                    "title": "Language",
                    "name": "Language",
                    "itemId": "LanguageForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "languageId",
                         "itemId": "languageId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Language Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Language Id<font color='red'> *<\/font>",
                         "fieldId": "C45328E2-B24C-42E9-B216-3CD8FFAC7587",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "languageId"
                    }, {
                         "name": "language",
                         "itemId": "language",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Language",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Language<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "2FF5A1D7-BFDC-4F32-8749-05D05A3898B8",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "language",
                         "columnWidth": 0.5
                    }, {
                         "name": "languageType",
                         "itemId": "languageType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Language Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Language Type",
                         "fieldId": "5675517F-E439-4C4A-A995-637C1AD567D3",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "languageType",
                         "columnWidth": 0.5
                    }, {
                         "name": "languageDescription",
                         "itemId": "languageDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Description",
                         "fieldId": "847EB074-EB64-48F2-A234-F9440FB323BE",
                         "bindable": "languageDescription",
                         "columnWidth": 0.5
                    }, {
                         "name": "languageIcon",
                         "itemId": "languageIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Icon",
                         "fieldId": "3821FBD0-5098-4212-8749-DA102EA5205F",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "languageIcon",
                         "columnWidth": 0.5
                    }, {
                         "name": "alpha2",
                         "itemId": "alpha2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Alpha 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Alpha 2",
                         "fieldId": "026A264E-A681-4F2E-BD86-7DA767A37ACF",
                         "minLength": "0",
                         "maxLength": "2",
                         "bindable": "alpha2",
                         "columnWidth": 0.5
                    }, {
                         "name": "alpha3",
                         "itemId": "alpha3",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Alpha 3",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Alpha 3",
                         "fieldId": "D35EB829-86D9-4E5D-AC08-E0AEFD0998FB",
                         "minLength": "0",
                         "maxLength": "3",
                         "bindable": "alpha3",
                         "columnWidth": 0.5
                    }, {
                         "name": "alpha4",
                         "itemId": "alpha4",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Alpha 4",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Alpha 4",
                         "fieldId": "5445A1E7-3B39-4DA8-9880-368CC825C96E",
                         "minLength": "0",
                         "maxLength": "4",
                         "bindable": "alpha4",
                         "columnWidth": 0.5
                    }, {
                         "name": "alpha4parentid",
                         "itemId": "alpha4parentid",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Aplha4 Parent Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Aplha4 Parent Id",
                         "fieldId": "86B7C638-9FDD-4AA9-98EF-CCC7C39C0E39",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "alpha4parentid",
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
                         "fieldId": "CAC49DF1-0AA9-403C-8438-D00F7C88E9B1",
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
                         "customId": 937,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 937,
                              "customId": 953
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 937,
                              "customId": 954,
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
                              "parentId": 937,
                              "customId": 955,
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
                    "displayName": "Language",
                    "title": "Details Grid",
                    "name": "LanguageGrid",
                    "itemId": "LanguageGrid",
                    "restURL": "/Language",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Language Id",
                         "dataIndex": "languageId",
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
                         "header": "Language",
                         "dataIndex": "language",
                         "flex": 1
                    }, {
                         "header": "Language Type",
                         "dataIndex": "languageType",
                         "flex": 1
                    }, {
                         "header": "Description",
                         "dataIndex": "languageDescription",
                         "flex": 1
                    }, {
                         "header": "Icon",
                         "dataIndex": "languageIcon",
                         "flex": 1
                    }, {
                         "header": "Alpha 2",
                         "dataIndex": "alpha2",
                         "flex": 1
                    }, {
                         "header": "Alpha 3",
                         "dataIndex": "alpha3",
                         "flex": 1
                    }, {
                         "header": "Alpha 4",
                         "dataIndex": "alpha4",
                         "flex": 1
                    }, {
                         "header": "Aplha4 Parent Id",
                         "dataIndex": "alpha4parentid",
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
               "displayName": "Language",
               "title": "Language",
               "name": "Language",
               "itemId": "LanguageForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "languageId",
                    "itemId": "languageId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Language Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Language Id<font color='red'> *<\/font>",
                    "fieldId": "C45328E2-B24C-42E9-B216-3CD8FFAC7587",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "languageId"
               }, {
                    "name": "language",
                    "itemId": "language",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Language",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Language<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "2FF5A1D7-BFDC-4F32-8749-05D05A3898B8",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "language",
                    "columnWidth": 0.5
               }, {
                    "name": "languageType",
                    "itemId": "languageType",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Language Type",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Language Type",
                    "fieldId": "5675517F-E439-4C4A-A995-637C1AD567D3",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "languageType",
                    "columnWidth": 0.5
               }, {
                    "name": "languageDescription",
                    "itemId": "languageDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Description",
                    "fieldId": "847EB074-EB64-48F2-A234-F9440FB323BE",
                    "bindable": "languageDescription",
                    "columnWidth": 0.5
               }, {
                    "name": "languageIcon",
                    "itemId": "languageIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Icon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Icon",
                    "fieldId": "3821FBD0-5098-4212-8749-DA102EA5205F",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "languageIcon",
                    "columnWidth": 0.5
               }, {
                    "name": "alpha2",
                    "itemId": "alpha2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Alpha 2",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Alpha 2",
                    "fieldId": "026A264E-A681-4F2E-BD86-7DA767A37ACF",
                    "minLength": "0",
                    "maxLength": "2",
                    "bindable": "alpha2",
                    "columnWidth": 0.5
               }, {
                    "name": "alpha3",
                    "itemId": "alpha3",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Alpha 3",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Alpha 3",
                    "fieldId": "D35EB829-86D9-4E5D-AC08-E0AEFD0998FB",
                    "minLength": "0",
                    "maxLength": "3",
                    "bindable": "alpha3",
                    "columnWidth": 0.5
               }, {
                    "name": "alpha4",
                    "itemId": "alpha4",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Alpha 4",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Alpha 4",
                    "fieldId": "5445A1E7-3B39-4DA8-9880-368CC825C96E",
                    "minLength": "0",
                    "maxLength": "4",
                    "bindable": "alpha4",
                    "columnWidth": 0.5
               }, {
                    "name": "alpha4parentid",
                    "itemId": "alpha4parentid",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Aplha4 Parent Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Aplha4 Parent Id",
                    "fieldId": "86B7C638-9FDD-4AA9-98EF-CCC7C39C0E39",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "alpha4parentid",
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
                    "fieldId": "CAC49DF1-0AA9-403C-8438-D00F7C88E9B1",
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
                    "customId": 937,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 937,
                         "customId": 953
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 937,
                         "customId": 954,
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
                         "parentId": 937,
                         "customId": 955,
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