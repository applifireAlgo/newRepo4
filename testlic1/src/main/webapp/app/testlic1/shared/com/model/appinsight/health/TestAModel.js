Ext.define('Testlic1.testlic1.shared.com.model.appinsight.health.TestAModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "aid",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "anm",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "ano",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "total",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "ano1",
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