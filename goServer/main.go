package main

import (
	"container/list"
	"google.golang.org/grpc"
	"google.golang.org/grpc/grpclog"
	"net"
)

type server struct {
	UnimplementedKotlinServiceServer
}

type pokemon struct {
	base_experience int32
	height          int32
	id              int32
	name            string
	weight          int32
	image           string
}

var pokemons = list.New()

func (s *server) SendMessage(in *PokemonMessage, obs KotlinService_SendMessageServer) error {
	pokemons.PushBack(pokemon{
		in.BaseExperience,
		in.Height,
		in.Id,
		in.Name,
		in.Weight,
		in.Image,
	})

	currPokemon := pokemons.Front().Value.(pokemon)
	currElem := pokemons.Front()
	for i := 0; i < pokemons.Len(); i++ {

		mMessage := PokemonResponseMessage{
			Id:             currPokemon.id,
			BaseExperience: currPokemon.base_experience,
			Height:         currPokemon.height,
			Weight:         currPokemon.weight,
			Name:           currPokemon.name,
			Image:          currPokemon.image,
		}
		obs.Send(&mMessage)
		if currElem.Next() != nil {
			currElem = currElem.Next()
		}
		currPokemon = currElem.Value.(pokemon)
	}
	return nil
}

func main() {
	listener, err := net.Listen("tcp", ":8086")

	if err != nil {
		grpclog.Fatalf("failed to listen: %v", err)
	}

	opts := []grpc.ServerOption{}
	grpcServer := grpc.NewServer(opts...)

	RegisterKotlinServiceServer(grpcServer, &server{})
	grpcServer.Serve(listener)
}
