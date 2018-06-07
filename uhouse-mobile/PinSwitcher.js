import React, { Component } from 'react';
import { Button, StyleSheet, View, TextInput, Text, AsyncStorage  } from 'react-native';

import { UriStorageKey } from './UriSettings'; 

export default class PinSwitcher extends Component {

  _pressOn = () => {
      let uri = `${this.state.baseUri}/api/pin/${1}/on`;
      fetch(uri, {
        method: 'POST'
      })
  }

    _pressOff = () => {
        let uri = `${this.state.baseUri}/api/pin/${1}/off`;
        fetch(uri, {
        method: 'POST'
        })
        }
  state = {baseUri:'http://192.168.0.103:8090'}

  constructor(props) {
      super(props);
      AsyncStorage.getItem(UriStorageKey)
      .then(uri => {
         this.state.baseUri = uri;

      });
      
  }

  render() {  
    return (
        <View style={styles.container}>
            <View style={styles.alternativeLayoutButtonContainer}>
                <Button
                    onPress={() => {}}
                    title="Pin #1"
                />
                <Button
                    onPress={this._pressOn}
                    title="ON"
                    color="green"
                />
                <Button
                    onPress={this._pressOff}
                    title="OFF"
                    color="red"
                />
            </View>
        </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
   flex: 1,
   justifyContent: 'center',
  },
  buttonContainer: {
    margin: 20
  },
  alternativeLayoutButtonContainer: {
    margin: 20,
    flexDirection: 'row',
    justifyContent: 'space-evenly'
  }
})