import React from 'react'
import { Text, View } from 'react-native';

const Item = ({date}) => (
    <View>
        <Text>I am the item -- {date}</Text> 
    </ View>
)

export default Item;