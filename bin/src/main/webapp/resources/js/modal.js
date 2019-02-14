(function(window,document){
   
	
    DOM = 
    {
       marco:undefined,
       modal:undefined,
       settings:{
         id:"modal",
         background:"background-modal",
         content:"content-modal",
         class_title:"",
         h_title:"",
         class_content:"",
         h_contenido:"<h1>contenido</h1>",
         class_footer:"",
         h_footer:"",
         botonera:true,
         btnclose:undefined,
         class_close:""
       },
       viewModal:function(event)
       {
           var modal = document.getElementById(this.settings.id);
         
           modal.style = "display:block;";
           if(event != undefined)
           {
        	   event.preventDefault();
           }
           
       },
       createModal:function(object)
       {
         if(Object.keys(object).length > 0)
         {
             try
             {
                 if(object.id != undefined)
                 {
                   this.settings.id = object.id;
                 }
                 if(object.background != undefined)
                 {
                   this.settings.background = object.background; 
                 }
                 if(object.class_title != undefined)
                 {
                    this.settings.class_title = object.class_title;   
                 }
                 if(object.h_title != undefined)
                 {
                   this.settings.h_title = object.h_title;   
                 }
                 if(object.h_contenido != undefined)
                 {
                   this.settings.h_contenido = document.getElementById(object.h_contenido);   
                 }
                 if(object.clas_content != undefined)
                 {
                   this.settings.clas_content = object.clas_content;   
                 }
                 if(object.class_footer != undefined)
                 {
                   this.settings.class_footer = object.class_footer;   
                 }
                 if(object.class_close != undefined)
                 {
                   this.settings.class_close = object.class_close;   
                 }
              }
             catch(e) {}
           
              var marco = document.getElementById(this.settings.id);
              var content = undefined;
              if(document.getElementById(this.settings.content) == null)
              {
                content = document.createElement("div");
                content.setAttribute("class",this.settings.content);
                content.setAttribute("id",this.settings.content);
                marco.appendChild(content);
              }
              else
              {
            	 content = document.getElementById(this.settings.content);
            	 content.setAttribute("class",this.settings.content);
                 content.setAttribute("id",this.settings.content);
                 marco.appendChild(content);
              }
           
              if(document.getElementById(this.settings.class_title) == null)
              {
                 var title = document.createElement("div");
                 title.setAttribute("class",this.settings.class_title);
                 title.setAttribute("id",this.settings.class_title);
                 title.innerHTML = this.settings.h_title;
                 content.appendChild(title);
              }
           
              if(!marco.hasAttribute(this.settings.background)){
                marco.setAttribute("class",this.settings.background);
              }
               
              if(document.getElementById(this.settings.class_content) == null)
              {
                 var contenido = document.createElement("div");
                 contenido.setAttribute("class",this.settings.clas_content);
                 contenido.setAttribute("id",this.settings.clas_content);
                 contenido.appendChild(this.settings.h_contenido);
                 content.appendChild(contenido);
              }
              
              if(document.getElementById(this.settings.class_footer) == null)
              {
            	 
            	if(this.settings.botonera){
            		 this.btnclose = document.createElement("a");
                	 this.btnclose.innerHTML = "Cerrar";
                	 this.btnclose.setAttribute("href","javascript:void(0)");
                	 this.btnclose.onclick  = function(){
                		
                		  var divid = document.getElementById("modal");
                		  divid.style = "display:none; transition:all .4s";
                	 };
                	 
                	 var action = document.createElement("a");
                	 action.innerHTML = "Agregar";
                	 action.setAttribute("class",this.settings.class_close+" btn");
                	 
                	 action.onclick  = function(){
                		 $$.hiddenModal();

               		  var divid = document.getElementById("modal");
               		  divid.style = "display:none; transition:all .4s";
               		 };
                	 
                	 this.btnclose.setAttribute("class",this.settings.class_close+" btn");
                	 this.btnclose.setAttribute("id",this.settings.class_close);
                     var footer = document.createElement("div");
                     footer.setAttribute("class",this.settings.class_footer);
                     footer.setAttribute("id",this.settings.class_footer);
                     footer.appendChild(action);
                     footer.appendChild(this.btnclose);
                     content.appendChild(footer);
            	}
              }
               
         }
         
       }
    }
 
   
    window.modalxpd = $_Modal = DOM;
    
  
})(window,document);




