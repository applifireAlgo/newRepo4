Ext.define('Testlic1.testlic1.web.com.controller.appinsight.health.NewuiController', {
     extend: 'Testlic1.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.NewuiController',
     onB6Click: function(me, e, eOpts) {
          this.view.down('#textfield_ext_5026').reset();
          this.view.down('#textfield_ext_5036').reset();
          this.view.down('#textfield_ext_5048').reset();
          this.view.down('#textfield_ext_5062').reset();
          this.view.down('#textfield_ext_5078').reset();
          this.view.down('#textfield_ext_5096').reset();
          this.view.down('#textfield_ext_5116').reset();
     },
     onB5Click: function(me, e, eOpts) {
          var jsonData = {};
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/Address/',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               maskEnable: true,
               maskEle: scope,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         Ext.Msg.alert('Server Response', responseText.response.message);
                    } else {
                         scope.sender.responseHandler(responseText);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    scope.sender.responseHandler(responseText);
               }
          }, scope);
     }
});