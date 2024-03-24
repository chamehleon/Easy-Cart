var $topeContainer = $('.isotope-grid');
var filterPrice = '';
var filterCategory = '';

// filter items on button click
$('.filter-tope-group').on('click', 'button', function () {
    // Clear the existing category filters
    filterCategory = $(this).attr('data-filter');
   // Add the new category filter
    var comboFilter = filterCategory + filterPrice;
    $topeContainer.isotope({filter: comboFilter});
});
$('.filter-price-group').on('click', 'button', function () {

    filterPrice = $(this).attr('data-filter');
    var comboFilter = filterCategory + filterPrice;
    $topeContainer.isotope({filter: comboFilter});
});


// function getComboFilter(filters) {
//     var i = 0;
//     var comboFilters = [];
//     for (var prop in filters) {
//         var filterGroup = filters[prop];
//         if (!filterGroup.length) {
//             continue;
//         }
//         if (i === 0) {
//             comboFilters = filterGroup.slice(0);
//         } else {
//             var filterSelectors = [];
//             var groupCombo = comboFilters.slice(0);
//             for (var k = 0, len3 = filterGroup.length; k < len3; k++) {
//                 for (var j = 0, len2 = groupCombo.length; j < len2; j++) {
//                     filterSelectors.push(groupCombo[j] + filterGroup[k]);
//                 }
//             }
//             comboFilters = filterSelectors;
//         }
//         i++;
//     }
//     comboFilters.sort();
//     var comboFilter = comboFilters.join(', ');
//     return comboFilter;
// }

// init Isotope
$(window).on('load', function () {
    var $grid = $topeContainer.each(function () {
        $(this).isotope({
            itemSelector: '.isotope-item',
            layoutMode: 'fitRows',
            percentPosition: true,
            animationEngine : 'best-available',
            masonry: {
                columnWidth: '.isotope-item'
            }
        });
    });
});

var isotopeButton = $('.filter-tope-group button');

$(isotopeButton).each(function(){
    $(this).on('click', function(){
        for(var i=0; i<isotopeButton.length; i++) {
            $(isotopeButton[i]).removeClass('how-active1');
        }

        $(this).addClass('how-active1');
    });
});

var priceFilterButtons = $('.filter-price-group button');

$(priceFilterButtons).each(function(){
    $(this).on('click', function(){
        for(var i=0; i<priceFilterButtons.length; i++) {
            $(priceFilterButtons[i]).removeClass('filter-link-active');
        }

        $(this).addClass('filter-link-active');
    });
});