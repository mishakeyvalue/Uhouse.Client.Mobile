import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

import UriSettings from './UriSettings';
import PinSwitcher from './PinSwitcher';

export default class App extends React.Component {
  render() {
    return (
    <View style={{flex: 1, backgroundColor: 'powderblue'}}>
      <PinSwitcher />
      <UriSettings />
      {/* <View style={{flex: 2, backgroundColor: 'skyblue'}} />
      <View style={{flex: 3, backgroundColor: 'steelblue'}} /> */}
    </View>
    );    
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
