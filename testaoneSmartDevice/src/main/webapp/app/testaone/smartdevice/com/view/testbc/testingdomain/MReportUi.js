Ext.define('Testaone.testaone.smartdevice.com.view.testbc.testingdomain.MReportUi', {
     "xtype": "mReportUi",
     "items": [{
          "xtype": "reportView",
          "name": "Stud",
          "title": "Stud Report",
          "isCustomReport": true,
          "reportWidgets": ["2", "3"],
          "refId": "A9E83F01-6EBD-4645-B375-942D2ECA3884",
          "margin": 5,
          "itemId": "reportView_ext_16735"
     }],
     "border": true,
     "autoScroll": false,
     "layout": "fit",
     "title": "Fit Layout",
     "margin": 5,
     "itemId": "panel_ext_16727",
     "dockedItems": [],
     "requires": ["Testaone.view.smartdevice.reportview.ReportMainView", "Testaone.testaone.smartdevice.com.controller.testbc.testingdomain.MReportUiController", "Testaone.testaone.shared.com.viewmodel.testbc.testingdomain.MReportUiViewModel", "Testaone.testaone.shared.com.model.testbc.testingdomain.MReportUiModel"],
     "extend": "Ext.panel.Panel",
     "viewModel": "MReportUiViewModel",
     "controller": "MReportUiController"
});