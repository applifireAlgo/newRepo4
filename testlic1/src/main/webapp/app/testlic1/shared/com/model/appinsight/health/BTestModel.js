Ext.define('Testlic1.testlic1.shared.com.model.appinsight.health.BTestModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "bid",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "bnm",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "bno",
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