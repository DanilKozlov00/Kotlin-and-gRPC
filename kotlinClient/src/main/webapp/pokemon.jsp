<html lang="en">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://thymeleaf.org">
<body>


<div id="info" class="pokeInfo">
    <table>
        <tr>
            <img th:src="${pokemon.image}"/>
        </tr>
        <tbody>
        <p th:text="${pokemon.name}"></p>
        </tbody>
        <tr>
            <th>Id</th>
            <th>Base_experience</th>
            <th>Height</th>
            <th>Weight</th>
        </tr>
        <tr>
            <th><p th:text="${pokemon.id}"></p></th>
            <th><p th:text="${pokemon.base_experience}"></p></th>
            <th><p th:text="${pokemon.height}"></p></th>
            <th><p th:text="${pokemon.weight}"></p></th>
        </tr>
    </table>
</div>

<br>
<br>
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
        width: 500px;
        height: 500px;
        display: block;
        margin-left: auto;
        margin-right: auto;
    }

    .pokeInfo {
        text-align: center;
    }

    .allPokemons {
        margin-left: -95px;
    }

    table, th, td {
        border: 1px solid black;
        position: center;
        margin-left: 120px;
    }


</style>
</html>
