# Kotlin-and-gRPC
Kotlin + gRPC + Spring + Vert.x + pokeapi example

Простой проект для ознакомления с технологиями Vert.x и gRPC и Keycloack, а так же закрепления навыков Kotlin.
В проекте присутвуют три папки, клиент и два сервера с  одинаковым функционалом но на разных языках (Kotlin,Go).
Клиент поднимает сайт доступный по localhost:8080. После чего пользователь может ввести число для получения покемона id которого равно этому числу. 
Затем на сервер отправляется запрос по gRPC с полученным покемоном, там он сохраняется в список и возращается так же по gRPC список всех запрошеных покемонов.


## Стартовая страница

![Image](https://github.com/DanilKozlov00/Kotlin-and-gRPC/blob/main/images/indexPage.png)

## Cтраница авторизации

![Image](https://github.com/DanilKozlov00/Kotlin-and-gRPC/blob/main/images/authPage.png)

## Страница ввода id покемона

![Image](https://github.com/DanilKozlov00/Kotlin-and-gRPC/blob/main/images/inputPokemonId.png)

## Страница просмотра всех запрошенных покемонов
Вверху, запрошенный на данный момент покемон

Внизу, все покемоны которые когда-то были запрошены
![Image](https://github.com/DanilKozlov00/Kotlin-and-gRPC/blob/main/images/pokemonList.png)

## Настройка keycloack client

![Image](https://github.com/DanilKozlov00/Kotlin-and-gRPC/blob/main/images/keycloakClientSettings.png)

