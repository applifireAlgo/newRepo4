Ext.define('Testschedular.testschedular.web.com.view.organization.locationmanagement.CountryMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CountryMainController",
     "restURL": "/Country",
     "defaults": {
          "split": true
     },
     "requires": ["Testschedular.testschedular.shared.com.model.organization.locationmanagement.CountryModel", "Testschedular.testschedular.web.com.controller.organization.locationmanagement.CountryMainController", "Testschedular.testschedular.shared.com.viewmodel.organization.locationmanagement.CountryViewModel"],
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
               "displayName": "Country",
               "name": "CountryTreeContainer",
               "itemId": "CountryTreeContainer",
               "restURL": "/Country",
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
                    "itemId": "CountryTree",
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
                    "items": [{
                         "name": "countryName",
                         "itemId": "countryName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name",
                         "fieldId": "46B04422-1EA4-4B4B-AD1F-3B14F6A1C614",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "countryName"
                    }, {
                         "name": "countryCode1",
                         "itemId": "countryCode1",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Code 1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Code 1",
                         "fieldId": "85CB0DA6-AA77-4AD5-B97A-233ED4AFA3A8",
                         "minLength": "0",
                         "maxLength": "3",
                         "bindable": "countryCode1"
                    }]
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
                    "displayName": "Country",
                    "title": "Country",
                    "name": "Country",
                    "itemId": "CountryForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Country Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country Code<font color='red'> *<\/font>",
                         "fieldId": "F47BC0EE-26C1-4A1E-BE2D-B22C535F7E43",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "countryId"
                    }, {
                         "name": "countryName",
                         "itemId": "countryName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "46B04422-1EA4-4B4B-AD1F-3B14F6A1C614",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "countryName",
                         "columnWidth": 0.5
                    }, {
                         "name": "countryCode1",
                         "itemId": "countryCode1",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Code 1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Code 1",
                         "fieldId": "85CB0DA6-AA77-4AD5-B97A-233ED4AFA3A8",
                         "minLength": "0",
                         "maxLength": "3",
                         "bindable": "countryCode1",
                         "columnWidth": 0.5
                    }, {
                         "name": "countryCode2",
                         "itemId": "countryCode2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Code 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Code 2",
                         "fieldId": "1C568B24-7356-4DF3-8048-F72CAA9AD027",
                         "minLength": "0",
                         "maxLength": "3",
                         "bindable": "countryCode2",
                         "columnWidth": 0.5
                    }, {
                         "name": "countryFlag",
                         "itemId": "countryFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "3002A370-C6DB-4261-9D70-16719A5B3C0D",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "countryFlag",
                         "columnWidth": 0.5
                    }, {
                         "name": "capital",
                         "itemId": "capital",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Capital",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capital",
                         "fieldId": "DAB9AA1C-1923-4ACD-B64A-AB955A8D218E",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "capital",
                         "columnWidth": 0.5
                    }, {
                         "name": "currencyCode",
                         "itemId": "currencyCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Currency Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Currency Code",
                         "fieldId": "47AF455C-05D4-4EDD-BF6E-CEC152A79E5D",
                         "minLength": "0",
                         "maxLength": "3",
                         "bindable": "currencyCode",
                         "columnWidth": 0.5
                    }, {
                         "name": "currencyName",
                         "itemId": "currencyName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Currency Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Currency Name",
                         "fieldId": "6850B821-D6D0-44E2-860E-D7549508ED5F",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "currencyName",
                         "columnWidth": 0.5
                    }, {
                         "name": "currencySymbol",
                         "itemId": "currencySymbol",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Currency Symbol",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Currency Symbol",
                         "fieldId": "E309A18B-C49B-45F0-8B40-E84D8A9B28B0",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "currencySymbol",
                         "columnWidth": 0.5
                    }, {
                         "name": "capitalLatitude",
                         "itemId": "capitalLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Capital Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capital Latitude",
                         "fieldId": "E9A2612C-AFF6-4248-87C0-E5CDC8CA205A",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "capitalLatitude",
                         "columnWidth": 0.5
                    }, {
                         "name": "capitalLongitude",
                         "itemId": "capitalLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Capital Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capital Longitude",
                         "fieldId": "22A2A279-8F0E-4235-8681-5D2CD6ADF5E2",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "capitalLongitude",
                         "columnWidth": 0.5
                    }, {
                         "name": "isoNumeric",
                         "itemId": "isoNumeric",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "ISO Numeric",
                         "margin": "5 5 5 5",
                         "fieldLabel": "ISO Numeric",
                         "fieldId": "B9129ED3-E774-4971-BF3A-0C4C5654E16A",
                         "minValue": "0",
                         "maxValue": "1000",
                         "bindable": "isoNumeric",
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
                         "fieldId": "C09BB66E-EEC1-4600-9420-DB500AA2E92B",
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
                         "customId": 628,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 628,
                              "customId": 94
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": 5,
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 628,
                              "customId": 95,
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
                              "parentId": 628,
                              "customId": 96,
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
                    "displayName": "Country",
                    "title": "Details Grid",
                    "name": "CountryGrid",
                    "itemId": "CountryGrid",
                    "restURL": "/Country",
                    "store": [],
                    "columns": [{
                         "header": "Country Code",
                         "dataIndex": "countryId",
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
                         "header": "Name",
                         "dataIndex": "countryName",
                         "flex": 1
                    }, {
                         "header": "Code 1",
                         "dataIndex": "countryCode1",
                         "flex": 1
                    }, {
                         "header": "Code 2",
                         "dataIndex": "countryCode2",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "countryFlag",
                         "flex": 1
                    }, {
                         "header": "Capital",
                         "dataIndex": "capital",
                         "flex": 1
                    }, {
                         "header": "Currency Code",
                         "dataIndex": "currencyCode",
                         "flex": 1
                    }, {
                         "header": "Currency Name",
                         "dataIndex": "currencyName",
                         "flex": 1
                    }, {
                         "header": "Currency Symbol",
                         "dataIndex": "currencySymbol",
                         "flex": 1
                    }, {
                         "header": "Capital Latitude",
                         "dataIndex": "capitalLatitude",
                         "flex": 1
                    }, {
                         "header": "Capital Longitude",
                         "dataIndex": "capitalLongitude",
                         "flex": 1
                    }, {
                         "header": "ISO Numeric",
                         "dataIndex": "isoNumeric",
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
               "displayName": "Country",
               "title": "Country",
               "name": "Country",
               "itemId": "CountryForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Country Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country Code<font color='red'> *<\/font>",
                    "fieldId": "F47BC0EE-26C1-4A1E-BE2D-B22C535F7E43",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "countryId"
               }, {
                    "name": "countryName",
                    "itemId": "countryName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "46B04422-1EA4-4B4B-AD1F-3B14F6A1C614",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "countryName",
                    "columnWidth": 0.5
               }, {
                    "name": "countryCode1",
                    "itemId": "countryCode1",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Code 1",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Code 1",
                    "fieldId": "85CB0DA6-AA77-4AD5-B97A-233ED4AFA3A8",
                    "minLength": "0",
                    "maxLength": "3",
                    "bindable": "countryCode1",
                    "columnWidth": 0.5
               }, {
                    "name": "countryCode2",
                    "itemId": "countryCode2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Code 2",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Code 2",
                    "fieldId": "1C568B24-7356-4DF3-8048-F72CAA9AD027",
                    "minLength": "0",
                    "maxLength": "3",
                    "bindable": "countryCode2",
                    "columnWidth": 0.5
               }, {
                    "name": "countryFlag",
                    "itemId": "countryFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "3002A370-C6DB-4261-9D70-16719A5B3C0D",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "countryFlag",
                    "columnWidth": 0.5
               }, {
                    "name": "capital",
                    "itemId": "capital",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Capital",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capital",
                    "fieldId": "DAB9AA1C-1923-4ACD-B64A-AB955A8D218E",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "capital",
                    "columnWidth": 0.5
               }, {
                    "name": "currencyCode",
                    "itemId": "currencyCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Currency Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Currency Code",
                    "fieldId": "47AF455C-05D4-4EDD-BF6E-CEC152A79E5D",
                    "minLength": "0",
                    "maxLength": "3",
                    "bindable": "currencyCode",
                    "columnWidth": 0.5
               }, {
                    "name": "currencyName",
                    "itemId": "currencyName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Currency Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Currency Name",
                    "fieldId": "6850B821-D6D0-44E2-860E-D7549508ED5F",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "currencyName",
                    "columnWidth": 0.5
               }, {
                    "name": "currencySymbol",
                    "itemId": "currencySymbol",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Currency Symbol",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Currency Symbol",
                    "fieldId": "E309A18B-C49B-45F0-8B40-E84D8A9B28B0",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "currencySymbol",
                    "columnWidth": 0.5
               }, {
                    "name": "capitalLatitude",
                    "itemId": "capitalLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Capital Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capital Latitude",
                    "fieldId": "E9A2612C-AFF6-4248-87C0-E5CDC8CA205A",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "capitalLatitude",
                    "columnWidth": 0.5
               }, {
                    "name": "capitalLongitude",
                    "itemId": "capitalLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Capital Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capital Longitude",
                    "fieldId": "22A2A279-8F0E-4235-8681-5D2CD6ADF5E2",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "capitalLongitude",
                    "columnWidth": 0.5
               }, {
                    "name": "isoNumeric",
                    "itemId": "isoNumeric",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "ISO Numeric",
                    "margin": "5 5 5 5",
                    "fieldLabel": "ISO Numeric",
                    "fieldId": "B9129ED3-E774-4971-BF3A-0C4C5654E16A",
                    "minValue": "0",
                    "maxValue": "1000",
                    "bindable": "isoNumeric",
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
                    "fieldId": "C09BB66E-EEC1-4600-9420-DB500AA2E92B",
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
                    "customId": 628,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 628,
                         "customId": 94
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": 5,
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 628,
                         "customId": 95,
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
                         "parentId": 628,
                         "customId": 96,
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