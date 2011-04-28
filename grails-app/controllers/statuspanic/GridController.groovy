package statuspanic

class GridController {

    def module = { 
		return [
			model : [	
				['GREEN', 'Reviews', 'Iter 1', 'L@statuspanic'],
				['PINK', 'Decouple', 'Iter 3', 'Z@statuspanic, L@statuspanic, I@statuspanic'],
				['BLUE', 'Compliance', 'Iter 6', 'Z@statuspanic, H@statuspanic, P@statuspanic'],
				['SERVICE DESK', 'All brands', 'Iter 245', 'G@statuspanic, L@statuspanic'],
				['CI', 'Testing', 'Iter 34', 'L@statuspanic, G@statuspanic, I@statuspanic'],
				['Secrets', 'Testing', 'Iter 1', 'I@statuspanic, L@statuspanic']
			]
		]
	
	}
}
