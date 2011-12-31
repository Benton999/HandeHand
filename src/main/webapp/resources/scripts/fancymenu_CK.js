var SlideList = new Class({
    Implements: Options,
    options: {    //options par défaut si aucune option utilisateur n'est renseignée

        fancyTransition : 'Bounce',
        fancyEase : 'easeOut',
        fancyDuree : 500
    },
        
    initialize: function(menu, options) {
        this.setOptions(options); //enregistre les options utilisateur

        // store options
        var fancyduree = this.options.fancyDuree;                
        var fancytransition = new Fx.Transition(Fx.Transitions[this.options.fancyTransition][this.options.fancyEase])

        // if no active element in the menu, get out
        if (!menu.getElement('.active')) return false;

        this.menu = menu, this.current = this.menu.getElement('li.active');
		
        this.menu.getElements('li').each(function(item){
            item.addEvent('mouseover', function(){
                this.moveBg(item);
			//Cufon.refresh();
            }.bind(this));
            item.addEvent('mouseout', function(){
                this.moveBg(this.current);	
			//Cufon.refresh();			
            }.bind(this));
            item.addEvent('click', function(event){
                this.clickItem(event, item);	
			//Cufon.refresh();			
            }.bind(this));
        }.bind(this));
				
        this.back = new Element('li').addClass('maxiFancybackground').adopt(new Element('div').addClass('maxiFancycenter').adopt(new Element('div').addClass('maxiFancyleft')).adopt(new Element('div').addClass('maxiFancyright'))).injectInside(this.menu);
        this.back.set('morph', {duration: fancyduree, transition: fancytransition});

        if(this.current) this.setCurrent(this.current);
    },
	
    setCurrent: function(el, effect){
        this.back.setStyles({
            left: (el.offsetLeft)+'px',
            width: (el.offsetWidth)+'px'
            });
        (effect) ? this.back.effect('opacity').set(0).start(1) : this.back.setOpacity(1);
        this.current = el;
    },

    clickItem: function(event, item) {
        if(!this.current) this.setCurrent(item, true);
        this.current = item;
        //this.options.onClick(new Event(event), item);
    },

    moveBg: function(to) {
        if(!this.current) return;
        this.back.morph({
            left:  [this.back.offsetLeft, to.offsetLeft],
            width: [this.back.offsetWidth, to.offsetWidth]
        });

           
    }
});

SlideList.implement(new Options);

/*window.addEvent('domready', function() {
	// orange menu demo
	if($('fancymenu'))
		FancyExample = new SlideList($E('ul', 'fancymenu'), {transition: Fx.Transitions.backOut, duration: 700, onClick: function(ev, item) { ev.stop(); }});
	
	// profile demo
	if($('pictureselect')) PictureSelect = new SlideList('pictureselect', { onClick: function(ev, item) { ev.stop(); } });

});*/