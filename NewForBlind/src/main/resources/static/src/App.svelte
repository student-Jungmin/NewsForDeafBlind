<script>
	import Article from './Article.svelte';
	import Introduce from './Introduce.svelte';
	import Crew from './Crew.svelte';
	let state = 'article'
</script>

<style>
	.container1{
		display: grid;
		grid-template-columns: 1.5fr 4fr 1.5fr;
		text-align: left;
		background-color: black;
		color: white;
		cursor: default;
	}
	.container2{
		display: grid;
		grid-template-columns: 1.5fr 1fr 1fr 1fr 1fr 1.5fr;
		text-align: center;
		background-color: black;
		color: white;
	}
	a{
		color: white;
	}
	h2:hover{
		font-size: 170%;
		cursor: pointer;
		color: yellow;
	} 
</style>

<div class="container1">
	<div class="item" style="background-color:rgb(185, 182, 182)"></div>
	<div class="item" style="font-size:300%; padding-left:9%;">
		<img src="soong.png" 
		   width="80px;"
		   alt="soongsil" 
		   style="display: inline-block;">
		<b>HANTICLE &nbsp;&nbsp;&nbsp; ⠚⠗⠒⠓⠕⠋⠮</b>
	</div>
	<div class="item" style="background-color:rgb(185, 182, 182)"></div>
</div>

<div class="container2">
	<div class="item" style="background-color:rgb(185, 182, 182)"/>
	<div class="item">
		<h2 on:click={() => {state = 'article';}}>Article</h2>
	</div>
	<div class="item">
		<h2 on:click={() => {state = 'introduce';}}>Introduce</h2>
	</div>
	<div class="item">
		<h2 on:click={() => {state = 'crew';}}>Crew</h2>
	</div>
	<div class="item">
		<a href="https://github.com/TwoJJung/NewsForDeafBlind"
		   target="_blank"
		   style="text-decoration: none;">
		   <h2 style="display: inline-block;">
			<img src="github.png" 
			width="23px;"
			alt="git_mark" 
			style="display: inline-block;">
			Github</h2>
		</a>
	</div>
	<div class="item" style="background-color:rgb(185, 182, 182)"/>
</div>

{#if state === 'article'}
	<Article />
{:else if state === 'introduce'}
	<Introduce />
{:else if state === 'crew'}
	<Crew />
{/if}


