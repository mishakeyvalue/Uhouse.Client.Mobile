import React from 'react';

import { Button, Text, View } from 'react-native';

export default class Details extends React.Component {
    render() {
      return (
        <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
          <Text>Details Screen</Text>
          <Button
          title="Go to Details... again"
          onPress={() => this.props.navigation.push('Details')}
        />
  
          <Button
            title="Go to hell"
            onPress={() => this.props.navigation.popToTop()}
          />
        </View>
      );
    }
  }