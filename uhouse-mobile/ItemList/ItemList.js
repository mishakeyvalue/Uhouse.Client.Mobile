import React from 'react'
import { Text, View } from 'react-native';

import Item from "../Item"

const ItemList = ({items}) => (
    <View>
        {
            items.map(item =>
                <Item key={item.date} date={item.date}/>
            )
        }
    </View>
)

export default ItemList;