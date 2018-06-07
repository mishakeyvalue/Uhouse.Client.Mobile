import React, { Component } from 'react';
import { Alert, AppRegistry, Button, StyleSheet, View, TextInput, Text, AsyncStorage } from 'react-native';

export const UriStorageKey = "_station-uri-key";
export default class UriSettings extends Component {

  _onPressButton = () => {
    let uri = this.state.text;
    AsyncStorage.setItem(UriStorageKey, uri);
  }

  constructor(props) {
      super(props);
      this.state = {};      
      AsyncStorage.getItem(UriStorageKey)
      .then(v => {
        this.setState({text:v})
      })
      .catch(e => {throw e;})
  }

  render() {
    return (
      <View style={styles.container}>
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