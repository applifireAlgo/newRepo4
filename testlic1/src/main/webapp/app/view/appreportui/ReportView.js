Ext.define('Testlic1.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Testlic1.view.appreportui.ReportViewController',
	            'Testlic1.view.appreportui.datagrid.DataGridPanel',
	            'Testlic1.view.appreportui.datagrid.DataGridView',
	            'Testlic1.view.appreportui.querycriteria.QueryCriteriaView',
	            'Testlic1.view.appreportui.chart.ChartView',
	            'Testlic1.view.appreportui.datapoint.DataPointView',
	            'Testlic1.view.googlemaps.map.MapPanel',
	            'Testlic1.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData'
	}
});
