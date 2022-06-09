// import packageInfo from '../package.json'

const runEnvironment = process.env.NODE_ENV
const domain = window.location.hostname
const baseUrl = `http://${domain}:8080`

const config = {
  env: runEnvironment,
  // version: packageInfo.version,

  domain,
  baseUrl,
  apiUrl: `${baseUrl}`
}

export default config
