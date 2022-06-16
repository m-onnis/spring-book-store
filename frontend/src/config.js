// import packageInfo from '../package.json'

const runEnvironment = process.env.NODE_ENV
const domain = window.location.hostname

const config = {
  env: runEnvironment,
  // version: packageInfo.version,

  domain,
  apiUrl: `http://${domain}:8080`
}

export default config
