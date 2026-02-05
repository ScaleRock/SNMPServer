# Stack info

--- 

## Networking (Apache MINA):
- UDP socket
- timeout/retry
- event-driven receive/send

## Character encoding (Bouncy Castle):
- Type used: INTEGER, OCTET STRING, NULL, OBJECT IDENTIFIER, SEQUENCE / SEQUENCE OF
- Encoding rules: BER definite-length only (no indefinite-length)
- Construction: whenever possible, non-constructor encodings are used; constructor encodings only for sequences (like VarBind lists or PDU)
- Subset: defined by SMI — simplifies the full ASN.1/BER spec, enough to encode PDUs and managed objects.

