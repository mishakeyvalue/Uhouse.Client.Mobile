import React, { Component } from 'react';
import { Alert, AppRegistry, Button, StyleSheet, View, TextInput, Text } from 'react-native';

import { getUri, setUri } from '../infrastructure/uri-settings'

export default class UriSettings extends Component {

  _onPressButton = () => {
    let uri = this.state.text;
    setUri(uri);
  }

  constructor(props) {
      super(props);
      this.state = {};      
      getUri()
      .then(v => {
        this.setState({text:v})
      })
      .catch(e => {throw e;})
  }

  render() {
    return (
        <View style={styles.buttonContainer}>
          <Text style={{padding: 10, fontSize: 21}}>
            Station's URI settings 
          </Text> 
          <TextInput
            style={{height: 40}}
            value={this.state.text}
            onChangeText={(text) => this.setState({text})}
          />
          <Button
            onPress={this._onPressButton}
            title="Save"
          />
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
    justifyContent: 'space-between'
  }
})