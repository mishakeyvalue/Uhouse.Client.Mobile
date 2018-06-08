import React, { Component } from 'react';
import { Button, StyleSheet, View, TextInput, Text  } from 'react-native';

import { getUri } from './infrastructure/uri-settings'

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
  state = {baseUri:'http://192.168.0.103:8090'} // the default one

  constructor(props) {
      super(props);
      getUri()
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