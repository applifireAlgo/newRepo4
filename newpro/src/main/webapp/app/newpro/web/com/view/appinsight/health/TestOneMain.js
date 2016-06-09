Ext.define('Newpro.newpro.web.com.view.appinsight.health.TestOneMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestOneMainController",
     "restURL": "/TestOne",
     "defaults": {
          "split": true
     },
     "requires": ["Newpro.newpro.shared.com.model.appinsight.health.TestOneModel", "Newpro.newpro.web.com.controller.appinsight.health.TestOneMainController", "Newpro.newpro.shared.com.model.appinsight.health.TestAModel", "Newpro.newpro.shared.com.viewmodel.appinsight.health.TestOneViewModel"],
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
               "displayName": "TestOne",
               "name": "TestOneTreeContainer",
               "itemId": "TestOneTreeContainer",
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
                    "xtype": "form",
                    "displayName": "TestOne",
                    "name": "TestOne",
                    "itemId": "TestOneForm",
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
                                   "name": "ttid",
                                   "itemId": "ttid",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "ttid",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "ttid<font color='red'> *<\/font>",
                                   "fieldId": "20938924-C5F1-487D-92BD-F7887582A3DA",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "ttid"
                              }, {
                                   "name": "tnm",
                                   "itemId": "tnm",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "tnm",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "tnm<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "8DEEF48E-38C4-4821-B984-CC7D323641AC",
                                   "minLength": "1",
                                   "maxLength": "256",
                                   "bindable": "tnm",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "tno",
                                   "itemId": "tno",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "tno",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "tno<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "92E73DEF-076A-4542-9B45-FE20639C27C5",
                                   "minLength": "1",
                                   "maxLength": "256",
                                   "bindable": "tno",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "aaa",
                                   "itemId": "aaa",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "aaa",
                                   "margin": "5 5 5 5",
                                   "valueField": "primaryKey",
                                   "displayField": "primaryDisplay",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Newpro.newpro.shared.com.model.appinsight.health.TestAModel"
                                   },
                                   "allowBlank": false,
                                   "fieldLabel": "aaa<font color='red'> *<\/font>",
                                   "fieldId": "38535878-757C-4B5D-A75E-51579CD7F754",
                                   "restURL": "TestA",
                                   "bindable": "aaa",
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
                                   "fieldId": "2BE8216B-A48E-4796-96BD-10C4085ADEF5",
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
                    "displayName": "TestOne",
                    "title": "Details Grid",
                    "name": "TestOneGrid",
                    "itemId": "TestOneGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "ttid",
                         "dataIndex": "ttid",
                         "hidden": true,
                         "flex": 1
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
                         "header": "aaa",
                         "dataIndex": "aaa",
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
               "displayName": "TestOne",
               "name": "TestOne",
               "itemId": "TestOneForm",
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
                              "name": "ttid",
                              "itemId": "ttid",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "ttid",
                              "margin": "5 5 5 5",
                              "fieldLabel": "ttid<font color='red'> *<\/font>",
                              "fieldId": "20938924-C5F1-487D-92BD-F7887582A3DA",
                              "hidden": true,
                              "value": "",
                              "bindable": "ttid"
                         }, {
                              "name": "tnm",
                              "itemId": "tnm",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "tnm",
                              "margin": "5 5 5 5",
                              "fieldLabel": "tnm<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "8DEEF48E-38C4-4821-B984-CC7D323641AC",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "tnm",
                              "columnWidth": 0.5
                         }, {
                              "name": "tno",
                              "itemId": "tno",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "tno",
                              "margin": "5 5 5 5",
                              "fieldLabel": "tno<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "92E73DEF-076A-4542-9B45-FE20639C27C5",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "tno",
                              "columnWidth": 0.5
                         }, {
                              "name": "aaa",
                              "itemId": "aaa",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "aaa",
                              "margin": "5 5 5 5",
                              "valueField": "primaryKey",
                              "displayField": "primaryDisplay",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Newpro.newpro.shared.com.model.appinsight.health.TestAModel"
                              },
                              "allowBlank": false,
                              "fieldLabel": "aaa<font color='red'> *<\/font>",
                              "fieldId": "38535878-757C-4B5D-A75E-51579CD7F754",
                              "restURL": "TestA",
                              "bindable": "aaa",
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
                              "fieldId": "2BE8216B-A48E-4796-96BD-10C4085ADEF5",
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