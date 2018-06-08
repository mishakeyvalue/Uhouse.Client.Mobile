import { AsyncStorage } from 'react-native';

const UriStorageKey = "_station-uri-key";

export const setUri = (uri) => AsyncStorage.setItem(UriStorageKey, uri);
export const getUri = () => AsyncStorage.getItem(UriStorageKey);