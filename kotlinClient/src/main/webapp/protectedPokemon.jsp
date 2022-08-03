<html lang="en">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://thymeleaf.org">
<body>

<H1>Current Pokemon:</H1>
<br>
<div id="info" class="pokeInfo">
    <table>
        <tr>
            <th>Image</th>
            <th>Name</th>
            <th>Id</th>
            <th>Base_experience</th>
            <th>Height</th>
            <th>Weight</th>
        </tr>
        <tr>
            <th><img th:src="${pokemon.image}"></th>
            <th><p th:text="${pokemon.name}"></p></th>
            <th><p th:text="${pokemon.id}"></p></th>
            <th><p th:text="${pokemon.base_experience}"></p></th>
            <th><p th:text="${pokemon.height}"></p></th>
            <th><p th:text="${pokemon.weight}"></p></th>
        </tr>
    </table>
</div>

<br>
<br>
<h1>All pokemons:</h1>
<br>

<div id="allPokemons" class="allPokemons">
    <table>
        <tr>
            <th>Image</th>
            <th>Name</th>
            <th>Id</th>
            <th>Base_experience</th>
            <th>Height</th>
            <th>Weight</th>
        </tr>
        <tr th:each="pokemon : ${pokemons}">
            <th><img th:src="${pokemon.image}"></img></th>
            <th><p th:text="${pokemon.name}"></p></th>
            <th><p th:text="${pokemon.id}"></p></th>
            <th><p th:text="${pokemon.base_experience}"></p></th>
            <th><p th:text="${pokemon.height}"></p></th>
            <th><p th:text="${pokemon.weight}"></p></th>
        </tr>
    </table>

</div>

</body>
<form action="/">
    <button type="submit">Back</button>
</form>

<style>
    body {
        background-color: cornsilk;
        display: block;
        padding: 5px;
    }

    .pokeInfo {
        text-align: center;
    }


    table, th, td {
        table-layout: fixed;
        width: 100%;
        border: 1px solid black;
        position: center;
    }

    td {
        width: 100px;
    }

    th {
        width: 100px;
    }


</style>
</html>
