Ext.define('Testaone.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Testaone.view.appreportui.ReportViewController',
	            'Testaone.view.appreportui.datagrid.DataGridPanel',
	            'Testaone.view.appreportui.datagrid.DataGridView',
	            'Testaone.view.appreportui.querycriteria.QueryCriteriaView',
	            'Testaone.view.appreportui.chart.ChartView',
	            'Testaone.view.appreportui.datapoint.DataPointView',
	            'Testaone.view.googlemaps.map.MapPanel',
	            'Testaone.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	bodyStyle:{
        background:'#f6f6f6'
    },
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData',
		added:'onReportAdded'
	}
});
