package statuspanic

class WeatherController {

    def module = { 
		def search = params.search ?: "Brisbane,Queensland"
		
		def con = new URL("http://api.wunderground.com/auto/wui/geo/WXCurrentObXML/index.xml?query=${search}")
		def data = new XmlSlurper().parseText(con.text)
		
		return [ data: data ]
	}
}
