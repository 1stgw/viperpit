<template>
  <button-group
    id="TWP: MISSILE LAUNCH"
    description="TWP: MISSILE LAUNCH - Push"
    type="button">
    <control
      id="twpmissilelaunchpush"
      description="TWP: MISSILE LAUNCH - Push"
      label="MISSILE LAUNCH"
      type="button"
      role="none"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'TwpMissileLaunch',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
