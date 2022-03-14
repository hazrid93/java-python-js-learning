// SPDX-License-Identifier: MIT

pragma solidity ^0.8.4;

contract Pokedex {
    event Received(address,uint);

    constructor(){

    }
    
    enum Element {
        NONE,
        NORMAL,
        FIRE,
        WATER,
        LIGHTNING

    }
    struct Pokemon {
        string name;
        // 255 number of pokemon
        uint8 id;
        Element ele;
    }

    Pokemon[] public pokemons;

    function addPokemon(string memory _name, uint8 _id, Element _ele) public {
         pokemons.push(Pokemon(_name, _id, _ele));
    }

    function getPokemon(uint _index) public view returns (string memory,uint8,Element) {
        Pokemon storage pokemon = pokemons[_index];
        return (pokemon.name, pokemon.id, pokemon.ele);
    }

    function getBalance() public view returns (uint) {
        return address(this).balance;
    }


    fallback() external payable{
        emit Received(msg.sender,msg.value);
    }

    receive() external payable{
       // emit Received(msg.sender,msg.value);
    }

}