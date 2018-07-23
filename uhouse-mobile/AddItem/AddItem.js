import React from 'react'
import { connect } from 'react-redux'
import { addItem } from './actions'

import { View, Button } from 'react-native';

const AddItem = ({ dispatch }) => {
    let input;

    return (
        <View>
            <Button
                title="Add item"
                onPress={() => dispatch(addItem("42"))}
            />
        </View>

    )
}

export default connect()(AddItem);