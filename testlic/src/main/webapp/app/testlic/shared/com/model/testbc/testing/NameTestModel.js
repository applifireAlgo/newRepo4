Ext.define('Testlic.testlic.shared.com.model.testbc.testing.NameTestModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "tsid",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "sName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "sNo",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});