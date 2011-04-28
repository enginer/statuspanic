<div>
  <div class="bars">
  	<g:each in="${bars}" var="bar" status="count">
	 	<div class='bar' style='margin-top: ${bar.top_offset}px; width: ${bar_width}px; padding: 0 ${final_padding}px;'>
	        <div class='header'><span class="total">${bar.height}</span> / <span class="remaining">${bar.remaining}</span></div>
	        <div class='view' id='bar_${count+1}' style='height: ${bar.bar_height}px;'></div>
	    </div>
	</g:each>
  </div>
  <div style='clear:both'></div>
  <g:each in="${bars}" var="bar" status="count">
  	 <div class='bar-title' style='width: ${bar_width}px; padding: 0 ${final_padding}px;'>
        <span class='title'>${bar.name}</span>
     </div>
  </g:each>
</div>