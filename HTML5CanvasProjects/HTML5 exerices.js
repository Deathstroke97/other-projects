	var image = new Image();
	image.onload = function() {
		console.log('Loaded Image');
		ctx.drawImage(image, 0, 0, c.width, c.height);
	}
	image.src = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR77eNCiYN77LZWrfX2yAN4Ur8GpWTouSgqTb19OsQifa6oUEZGG4KzGfcc';

	var c = document.querySelector("#c");
var ctx = c.getContext("2d");
ctx.fillStyle = "blue";
// Start at (0,0) and draw a 50px x 50px blue rectangle.
ctx.fillRect(0,0,50,50);
// Start at (0,0) and clear a 25px x 25px rectangle.
ctx.clearRect(0,0,25,25);




	ctx.strokeStyle = '#33CC33';
	ctx.strokeRect(50, 50, 100, 100);

	ctx.fillStyle = 'blue';
	ctx.beginPath();
	ctx.moveTo(75,75);
	ctx.lineTo(125,125);
	ctx.lineTo(125,75);
	ctx.fill();

	ctx.strokeText("Hello Udacity!", 50, 10);



	var image = new Image();
	image.onload = function() {
		ctx.drawImage(image, 0, 0, c.width, c.height);
	}
	image.src = 'http://minionomaniya.ru/wp-content/uploads/2016/01/miniony_kartinki_na_rabochi_stol_1920x1080.jpg';






	<script>
	var c = document.querySelector('#c');
	var ctx = c.getContext('2d');
	ctx.font = '36pt Impact';
	ctx.textAlign = 'center';
	
	ctx.fillStyle = 'white';
	ctx.fillText('CANVAS MEMES!', 250, 60);
	
	ctx.stokeStyle = 'black';
	ctx.lineWidth = '3px';
	ctx.strokeText('CANVAS MEMES!', 250, 60);
	
	

	

</script>