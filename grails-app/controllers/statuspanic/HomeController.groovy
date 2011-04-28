package statuspanic

import org.codehaus.groovy.grails.web.util.WebUtils
import grails.converters.JSON
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

class HomeController implements ResourceLoaderAware {
	static final String CONFIG = "config.json"
	ResourceLoader resourceLoader
    
	def index = { 
		def config = resourceLoader.getResource(CONFIG).file.text
		def data = 	JSON.parse(config)
		def viewModel = [:]
		if(!data) {
			throw new Exception("JSON syntax error in ${CONFIG}")
		}
		viewModel.boardCSS = ""
		switch(data.rotate) {
			case "left":
				viewModel.boardCSS = "-webkit-transform: rotate(-90deg);\n"
				break;
			case "right":
				viewModel.boardCSS = "-webkit-transform: rotate(90deg);\n"
				break;
			case "flip":
				viewModel.boardCSS = "-webkit-transform: rotate(180deg);\n"
				break;
		}
		if(data.rotate ==~ "(left|right)") {
			viewModel.boardCSS += "height:"	
		} else {
			viewModel.boardCSS += "width:"
		}
		viewModel.boardCSS += (data.width ? "${data.width} px" : "100%") +";\n"
		
		viewModel.modules = data.modules.collect { module ->
			def map = [:]
			module.args = module.args ?: [:]
			module.args.width = module.width
			map.argstr = WebUtils.toQueryString(module.args)
			map["class"] = module["class"]
			map.style = "width: ${module.width}px;"
			map.style += module.height ? "height: ${module.height}px" : ""
			map.update = module.update
			map.name = module.name
			return map
		}
		return viewModel
	}
}
