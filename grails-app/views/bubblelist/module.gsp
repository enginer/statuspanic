<ul>
	<g:each in="${items}" var="bubble">
        <li>
            <span class='${bubble.color} bubble'>
                <span class='background'>E</span>
                <span class='display'>${bubble.name}</span>
            </span>
            <span class='content'>${bubble.desc}</span>
        </li>		
	</g:each>
</ul>