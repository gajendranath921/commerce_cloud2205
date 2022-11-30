/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
!(function () {
    'use strict';
    const t =
            window.ShadowRoot &&
            (void 0 === window.ShadyCSS || window.ShadyCSS.nativeShadow) &&
            'adoptedStyleSheets' in Document.prototype &&
            'replace' in CSSStyleSheet.prototype,
        e = Symbol(),
        o = new Map();
    class i {
        constructor(t, o) {
            if (((this._$cssResult$ = !0), o !== e))
                throw Error('CSSResult is not constructable. Use `unsafeCSS` or `css` instead.');
            this.cssText = t;
        }
        get styleSheet() {
            let e = o.get(this.cssText);
            return (
                t &&
                    void 0 === e &&
                    (o.set(this.cssText, (e = new CSSStyleSheet())), e.replaceSync(this.cssText)),
                e
            );
        }
        toString() {
            return this.cssText;
        }
    }
    const n = t
        ? (t) => t
        : (t) =>
              t instanceof CSSStyleSheet
                  ? ((t) => {
                        let o = '';
                        for (const e of t.cssRules) o += e.cssText;
                        return ((t) => new i('string' == typeof t ? t : t + '', e))(o);
                    })(t)
                  : t;
    var s, r;
    const a = {
            toAttribute(t, e) {
                switch (e) {
                    case Boolean:
                        t = t ? '' : null;
                        break;
                    case Object:
                    case Array:
                        t = null == t ? t : JSON.stringify(t);
                }
                return t;
            },
            fromAttribute(t, e) {
                let o = t;
                switch (e) {
                    case Boolean:
                        o = null !== t;
                        break;
                    case Number:
                        o = null === t ? null : Number(t);
                        break;
                    case Object:
                    case Array:
                        try {
                            o = JSON.parse(t);
                        } catch (t) {
                            o = null;
                        }
                }
                return o;
            }
        },
        l = (t, e) => e !== t && (e == e || t == t),
        h = { attribute: !0, type: String, converter: a, reflect: !1, hasChanged: l };
    class c extends HTMLElement {
        constructor() {
            super(),
                (this._$Et = new Map()),
                (this.isUpdatePending = !1),
                (this.hasUpdated = !1),
                (this._$Ei = null),
                this.o();
        }
        static addInitializer(t) {
            var e;
            (null !== (e = this.l) && void 0 !== e) || (this.l = []), this.l.push(t);
        }
        static get observedAttributes() {
            this.finalize();
            const t = [];
            return (
                this.elementProperties.forEach((e, o) => {
                    const i = this._$Eh(o, e);
                    void 0 !== i && (this._$Eu.set(i, o), t.push(i));
                }),
                t
            );
        }
        static createProperty(t, e = h) {
            if (
                (e.state && (e.attribute = !1),
                this.finalize(),
                this.elementProperties.set(t, e),
                !e.noAccessor && !this.prototype.hasOwnProperty(t))
            ) {
                const o = 'symbol' == typeof t ? Symbol() : '__' + t,
                    i = this.getPropertyDescriptor(t, o, e);
                void 0 !== i && Object.defineProperty(this.prototype, t, i);
            }
        }
        static getPropertyDescriptor(t, e, o) {
            return {
                get() {
                    return this[e];
                },
                set(i) {
                    const n = this[t];
                    (this[e] = i), this.requestUpdate(t, n, o);
                },
                configurable: !0,
                enumerable: !0
            };
        }
        static getPropertyOptions(t) {
            return this.elementProperties.get(t) || h;
        }
        static finalize() {
            if (this.hasOwnProperty('finalized')) return !1;
            this.finalized = !0;
            const t = Object.getPrototypeOf(this);
            if (
                (t.finalize(),
                (this.elementProperties = new Map(t.elementProperties)),
                (this._$Eu = new Map()),
                this.hasOwnProperty('properties'))
            ) {
                const t = this.properties,
                    e = [...Object.getOwnPropertyNames(t), ...Object.getOwnPropertySymbols(t)];
                for (const o of e) this.createProperty(o, t[o]);
            }
            return (this.elementStyles = this.finalizeStyles(this.styles)), !0;
        }
        static finalizeStyles(t) {
            const e = [];
            if (Array.isArray(t)) {
                const o = new Set(t.flat(1 / 0).reverse());
                for (const t of o) e.unshift(n(t));
            } else void 0 !== t && e.push(n(t));
            return e;
        }
        static _$Eh(t, e) {
            const o = e.attribute;
            return !1 === o
                ? void 0
                : 'string' == typeof o
                ? o
                : 'string' == typeof t
                ? t.toLowerCase()
                : void 0;
        }
        o() {
            var t;
            (this._$Ev = new Promise((t) => (this.enableUpdating = t))),
                (this._$AL = new Map()),
                this._$Ep(),
                this.requestUpdate(),
                null === (t = this.constructor.l) || void 0 === t || t.forEach((t) => t(this));
        }
        addController(t) {
            var e, o;
            (null !== (e = this._$Em) && void 0 !== e ? e : (this._$Em = [])).push(t),
                void 0 !== this.renderRoot &&
                    this.isConnected &&
                    (null === (o = t.hostConnected) || void 0 === o || o.call(t));
        }
        removeController(t) {
            var e;
            null === (e = this._$Em) || void 0 === e || e.splice(this._$Em.indexOf(t) >>> 0, 1);
        }
        _$Ep() {
            this.constructor.elementProperties.forEach((t, e) => {
                this.hasOwnProperty(e) && (this._$Et.set(e, this[e]), delete this[e]);
            });
        }
        createRenderRoot() {
            var e;
            const o =
                null !== (e = this.shadowRoot) && void 0 !== e
                    ? e
                    : this.attachShadow(this.constructor.shadowRootOptions);
            return (
                ((e, o) => {
                    t
                        ? (e.adoptedStyleSheets = o.map((t) =>
                              t instanceof CSSStyleSheet ? t : t.styleSheet
                          ))
                        : o.forEach((t) => {
                              const o = document.createElement('style'),
                                  i = window.litNonce;
                              void 0 !== i && o.setAttribute('nonce', i),
                                  (o.textContent = t.cssText),
                                  e.appendChild(o);
                          });
                })(o, this.constructor.elementStyles),
                o
            );
        }
        connectedCallback() {
            var t;
            void 0 === this.renderRoot && (this.renderRoot = this.createRenderRoot()),
                this.enableUpdating(!0),
                null === (t = this._$Em) ||
                    void 0 === t ||
                    t.forEach((t) => {
                        var e;
                        return null === (e = t.hostConnected) || void 0 === e ? void 0 : e.call(t);
                    });
        }
        enableUpdating(t) {}
        disconnectedCallback() {
            var t;
            null === (t = this._$Em) ||
                void 0 === t ||
                t.forEach((t) => {
                    var e;
                    return null === (e = t.hostDisconnected) || void 0 === e ? void 0 : e.call(t);
                });
        }
        attributeChangedCallback(t, e, o) {
            this._$AK(t, o);
        }
        _$Eg(t, e, o = h) {
            var i, n;
            const s = this.constructor._$Eh(t, o);
            if (void 0 !== s && !0 === o.reflect) {
                const r = (null !==
                    (n = null === (i = o.converter) || void 0 === i ? void 0 : i.toAttribute) &&
                    void 0 !== n
                    ? n
                    : a.toAttribute)(e, o.type);
                (this._$Ei = t),
                    null == r ? this.removeAttribute(s) : this.setAttribute(s, r),
                    (this._$Ei = null);
            }
        }
        _$AK(t, e) {
            var o, i, n;
            const s = this.constructor,
                r = s._$Eu.get(t);
            if (void 0 !== r && this._$Ei !== r) {
                const t = s.getPropertyOptions(r),
                    l = t.converter,
                    h =
                        null !==
                            (n =
                                null !==
                                    (i =
                                        null === (o = l) || void 0 === o
                                            ? void 0
                                            : o.fromAttribute) && void 0 !== i
                                    ? i
                                    : 'function' == typeof l
                                    ? l
                                    : null) && void 0 !== n
                            ? n
                            : a.fromAttribute;
                (this._$Ei = r), (this[r] = h(e, t.type)), (this._$Ei = null);
            }
        }
        requestUpdate(t, e, o) {
            let i = !0;
            void 0 !== t &&
                (((o = o || this.constructor.getPropertyOptions(t)).hasChanged || l)(this[t], e)
                    ? (this._$AL.has(t) || this._$AL.set(t, e),
                      !0 === o.reflect &&
                          this._$Ei !== t &&
                          (void 0 === this._$ES && (this._$ES = new Map()), this._$ES.set(t, o)))
                    : (i = !1)),
                !this.isUpdatePending && i && (this._$Ev = this._$EC());
        }
        async _$EC() {
            this.isUpdatePending = !0;
            try {
                await this._$Ev;
            } catch (t) {
                Promise.reject(t);
            }
            const t = this.scheduleUpdate();
            return null != t && (await t), !this.isUpdatePending;
        }
        scheduleUpdate() {
            return this.performUpdate();
        }
        performUpdate() {
            var t;
            if (!this.isUpdatePending) return;
            this.hasUpdated,
                this._$Et && (this._$Et.forEach((t, e) => (this[e] = t)), (this._$Et = void 0));
            let e = !1;
            const o = this._$AL;
            try {
                (e = this.shouldUpdate(o)),
                    e
                        ? (this.willUpdate(o),
                          null === (t = this._$Em) ||
                              void 0 === t ||
                              t.forEach((t) => {
                                  var e;
                                  return null === (e = t.hostUpdate) || void 0 === e
                                      ? void 0
                                      : e.call(t);
                              }),
                          this.update(o))
                        : this._$ET();
            } catch (t) {
                throw ((e = !1), this._$ET(), t);
            }
            e && this._$AE(o);
        }
        willUpdate(t) {}
        _$AE(t) {
            var e;
            null === (e = this._$Em) ||
                void 0 === e ||
                e.forEach((t) => {
                    var e;
                    return null === (e = t.hostUpdated) || void 0 === e ? void 0 : e.call(t);
                }),
                this.hasUpdated || ((this.hasUpdated = !0), this.firstUpdated(t)),
                this.updated(t);
        }
        _$ET() {
            (this._$AL = new Map()), (this.isUpdatePending = !1);
        }
        get updateComplete() {
            return this.getUpdateComplete();
        }
        getUpdateComplete() {
            return this._$Ev;
        }
        shouldUpdate(t) {
            return !0;
        }
        update(t) {
            void 0 !== this._$ES &&
                (this._$ES.forEach((t, e) => this._$Eg(e, this[e], t)), (this._$ES = void 0)),
                this._$ET();
        }
        updated(t) {}
        firstUpdated(t) {}
    }
    var u, d;
    (c.finalized = !0),
        (c.elementProperties = new Map()),
        (c.elementStyles = []),
        (c.shadowRootOptions = { mode: 'open' }),
        null === (s = globalThis.reactiveElementPolyfillSupport) ||
            void 0 === s ||
            s.call(globalThis, { ReactiveElement: c }),
        (null !== (r = globalThis.reactiveElementVersions) && void 0 !== r
            ? r
            : (globalThis.reactiveElementVersions = [])
        ).push('1.0.0');
    const p = globalThis.trustedTypes,
        v = p ? p.createPolicy('lit-html', { createHTML: (t) => t }) : void 0,
        f = `lit$${(Math.random() + '').slice(9)}$`,
        b = '?' + f,
        m = `<${b}>`,
        g = document,
        _ = (t = '') => g.createComment(t),
        y = (t) => null === t || ('object' != typeof t && 'function' != typeof t),
        x = Array.isArray,
        $ = /<(?:(!--|\/[^a-zA-Z])|(\/?[a-zA-Z][^>\s]*)|(\/?$))/g,
        A = /-->/g,
        w = />/g,
        S = />|[ 	\n\r](?:([^\s"'>=/]+)([ 	\n\r]*=[ 	\n\r]*(?:[^ 	\n\r"'`<>=]|("|')|))|$)/g,
        C = /'/g,
        E = /"/g,
        P = /^(?:script|style|textarea)$/i,
        k = ((t) => (e, ...o) => ({ _$litType$: t, strings: e, values: o }))(1),
        I = Symbol.for('lit-noChange'),
        T = Symbol.for('lit-nothing'),
        O = new WeakMap(),
        U = g.createTreeWalker(g, 129, null, !1),
        N = (t, e) => {
            const o = t.length - 1,
                i = [];
            let n,
                s = 2 === e ? '<svg>' : '',
                r = $;
            for (let e = 0; e < o; e++) {
                const o = t[e];
                let a,
                    l,
                    h = -1,
                    c = 0;
                for (; c < o.length && ((r.lastIndex = c), (l = r.exec(o)), null !== l); )
                    (c = r.lastIndex),
                        r === $
                            ? '!--' === l[1]
                                ? (r = A)
                                : void 0 !== l[1]
                                ? (r = w)
                                : void 0 !== l[2]
                                ? (P.test(l[2]) && (n = RegExp('</' + l[2], 'g')), (r = S))
                                : void 0 !== l[3] && (r = S)
                            : r === S
                            ? '>' === l[0]
                                ? ((r = null != n ? n : $), (h = -1))
                                : void 0 === l[1]
                                ? (h = -2)
                                : ((h = r.lastIndex - l[2].length),
                                  (a = l[1]),
                                  (r = void 0 === l[3] ? S : '"' === l[3] ? E : C))
                            : r === E || r === C
                            ? (r = S)
                            : r === A || r === w
                            ? (r = $)
                            : ((r = S), (n = void 0));
                const u = r === S && t[e + 1].startsWith('/>') ? ' ' : '';
                s +=
                    r === $
                        ? o + m
                        : h >= 0
                        ? (i.push(a), o.slice(0, h) + '$lit$' + o.slice(h) + f + u)
                        : o + f + (-2 === h ? (i.push(void 0), e) : u);
            }
            const a = s + (t[o] || '<?>') + (2 === e ? '</svg>' : '');
            return [void 0 !== v ? v.createHTML(a) : a, i];
        };
    class L {
        constructor({ strings: t, _$litType$: e }, o) {
            let i;
            this.parts = [];
            let n = 0,
                s = 0;
            const r = t.length - 1,
                a = this.parts,
                [l, h] = N(t, e);
            if (((this.el = L.createElement(l, o)), (U.currentNode = this.el.content), 2 === e)) {
                const t = this.el.content,
                    e = t.firstChild;
                e.remove(), t.append(...e.childNodes);
            }
            for (; null !== (i = U.nextNode()) && a.length < r; ) {
                if (1 === i.nodeType) {
                    if (i.hasAttributes()) {
                        const t = [];
                        for (const e of i.getAttributeNames())
                            if (e.endsWith('$lit$') || e.startsWith(f)) {
                                const o = h[s++];
                                if ((t.push(e), void 0 !== o)) {
                                    const t = i.getAttribute(o.toLowerCase() + '$lit$').split(f),
                                        e = /([.?@])?(.*)/.exec(o);
                                    a.push({
                                        type: 1,
                                        index: n,
                                        name: e[2],
                                        strings: t,
                                        ctor:
                                            '.' === e[1]
                                                ? M
                                                : '?' === e[1]
                                                ? j
                                                : '@' === e[1]
                                                ? Q
                                                : q
                                    });
                                } else a.push({ type: 6, index: n });
                            }
                        for (const e of t) i.removeAttribute(e);
                    }
                    if (P.test(i.tagName)) {
                        const t = i.textContent.split(f),
                            e = t.length - 1;
                        if (e > 0) {
                            i.textContent = p ? p.emptyScript : '';
                            for (let o = 0; o < e; o++)
                                i.append(t[o], _()), U.nextNode(), a.push({ type: 2, index: ++n });
                            i.append(t[e], _());
                        }
                    }
                } else if (8 === i.nodeType)
                    if (i.data === b) a.push({ type: 2, index: n });
                    else {
                        let t = -1;
                        for (; -1 !== (t = i.data.indexOf(f, t + 1)); )
                            a.push({ type: 7, index: n }), (t += f.length - 1);
                    }
                n++;
            }
        }
        static createElement(t, e) {
            const o = g.createElement('template');
            return (o.innerHTML = t), o;
        }
    }
    function B(t, e, o = t, i) {
        var n, s, r, a;
        if (e === I) return e;
        let l = void 0 !== i ? (null === (n = o._$Cl) || void 0 === n ? void 0 : n[i]) : o._$Cu;
        const h = y(e) ? void 0 : e._$litDirective$;
        return (
            (null == l ? void 0 : l.constructor) !== h &&
                (null === (s = null == l ? void 0 : l._$AO) || void 0 === s || s.call(l, !1),
                void 0 === h ? (l = void 0) : ((l = new h(t)), l._$AT(t, o, i)),
                void 0 !== i
                    ? ((null !== (r = (a = o)._$Cl) && void 0 !== r ? r : (a._$Cl = []))[i] = l)
                    : (o._$Cu = l)),
            void 0 !== l && (e = B(t, l._$AS(t, e.values), l, i)),
            e
        );
    }
    class R {
        constructor(t, e) {
            (this.v = []), (this._$AN = void 0), (this._$AD = t), (this._$AM = e);
        }
        get parentNode() {
            return this._$AM.parentNode;
        }
        get _$AU() {
            return this._$AM._$AU;
        }
        p(t) {
            var e;
            const {
                    el: { content: o },
                    parts: i
                } = this._$AD,
                n = (null !== (e = null == t ? void 0 : t.creationScope) && void 0 !== e
                    ? e
                    : g
                ).importNode(o, !0);
            U.currentNode = n;
            let s = U.nextNode(),
                r = 0,
                a = 0,
                l = i[0];
            for (; void 0 !== l; ) {
                if (r === l.index) {
                    let e;
                    2 === l.type
                        ? (e = new H(s, s.nextSibling, this, t))
                        : 1 === l.type
                        ? (e = new l.ctor(s, l.name, l.strings, this, t))
                        : 6 === l.type && (e = new z(s, this, t)),
                        this.v.push(e),
                        (l = i[++a]);
                }
                r !== (null == l ? void 0 : l.index) && ((s = U.nextNode()), r++);
            }
            return n;
        }
        m(t) {
            let e = 0;
            for (const o of this.v)
                void 0 !== o &&
                    (void 0 !== o.strings
                        ? (o._$AI(t, o, e), (e += o.strings.length - 2))
                        : o._$AI(t[e])),
                    e++;
        }
    }
    class H {
        constructor(t, e, o, i) {
            var n;
            (this.type = 2),
                (this._$AH = T),
                (this._$AN = void 0),
                (this._$AA = t),
                (this._$AB = e),
                (this._$AM = o),
                (this.options = i),
                (this._$Cg =
                    null === (n = null == i ? void 0 : i.isConnected) || void 0 === n || n);
        }
        get _$AU() {
            var t, e;
            return null !== (e = null === (t = this._$AM) || void 0 === t ? void 0 : t._$AU) &&
                void 0 !== e
                ? e
                : this._$Cg;
        }
        get parentNode() {
            let t = this._$AA.parentNode;
            const e = this._$AM;
            return void 0 !== e && 11 === t.nodeType && (t = e.parentNode), t;
        }
        get startNode() {
            return this._$AA;
        }
        get endNode() {
            return this._$AB;
        }
        _$AI(t, e = this) {
            (t = B(this, t, e)),
                y(t)
                    ? t === T || null == t || '' === t
                        ? (this._$AH !== T && this._$AR(), (this._$AH = T))
                        : t !== this._$AH && t !== I && this.$(t)
                    : void 0 !== t._$litType$
                    ? this.T(t)
                    : void 0 !== t.nodeType
                    ? this.S(t)
                    : ((t) => {
                          var e;
                          return (
                              x(t) ||
                              'function' ==
                                  typeof (null === (e = t) || void 0 === e
                                      ? void 0
                                      : e[Symbol.iterator])
                          );
                      })(t)
                    ? this.M(t)
                    : this.$(t);
        }
        A(t, e = this._$AB) {
            return this._$AA.parentNode.insertBefore(t, e);
        }
        S(t) {
            this._$AH !== t && (this._$AR(), (this._$AH = this.A(t)));
        }
        $(t) {
            this._$AH !== T && y(this._$AH)
                ? (this._$AA.nextSibling.data = t)
                : this.S(g.createTextNode(t)),
                (this._$AH = t);
        }
        T(t) {
            var e;
            const { values: o, _$litType$: i } = t,
                n =
                    'number' == typeof i
                        ? this._$AC(t)
                        : (void 0 === i.el && (i.el = L.createElement(i.h, this.options)), i);
            if ((null === (e = this._$AH) || void 0 === e ? void 0 : e._$AD) === n) this._$AH.m(o);
            else {
                const t = new R(n, this),
                    e = t.p(this.options);
                t.m(o), this.S(e), (this._$AH = t);
            }
        }
        _$AC(t) {
            let e = O.get(t.strings);
            return void 0 === e && O.set(t.strings, (e = new L(t))), e;
        }
        M(t) {
            x(this._$AH) || ((this._$AH = []), this._$AR());
            const e = this._$AH;
            let o,
                i = 0;
            for (const n of t)
                i === e.length
                    ? e.push((o = new H(this.A(_()), this.A(_()), this, this.options)))
                    : (o = e[i]),
                    o._$AI(n),
                    i++;
            i < e.length && (this._$AR(o && o._$AB.nextSibling, i), (e.length = i));
        }
        _$AR(t = this._$AA.nextSibling, e) {
            var o;
            for (
                null === (o = this._$AP) || void 0 === o || o.call(this, !1, !0, e);
                t && t !== this._$AB;

            ) {
                const e = t.nextSibling;
                t.remove(), (t = e);
            }
        }
        setConnected(t) {
            var e;
            void 0 === this._$AM &&
                ((this._$Cg = t), null === (e = this._$AP) || void 0 === e || e.call(this, t));
        }
    }
    class q {
        constructor(t, e, o, i, n) {
            (this.type = 1),
                (this._$AH = T),
                (this._$AN = void 0),
                (this.element = t),
                (this.name = e),
                (this._$AM = i),
                (this.options = n),
                o.length > 2 || '' !== o[0] || '' !== o[1]
                    ? ((this._$AH = Array(o.length - 1).fill(new String())), (this.strings = o))
                    : (this._$AH = T);
        }
        get tagName() {
            return this.element.tagName;
        }
        get _$AU() {
            return this._$AM._$AU;
        }
        _$AI(t, e = this, o, i) {
            const n = this.strings;
            let s = !1;
            if (void 0 === n)
                (t = B(this, t, e, 0)),
                    (s = !y(t) || (t !== this._$AH && t !== I)),
                    s && (this._$AH = t);
            else {
                const i = t;
                let r, a;
                for (t = n[0], r = 0; r < n.length - 1; r++)
                    (a = B(this, i[o + r], e, r)),
                        a === I && (a = this._$AH[r]),
                        s || (s = !y(a) || a !== this._$AH[r]),
                        a === T ? (t = T) : t !== T && (t += (null != a ? a : '') + n[r + 1]),
                        (this._$AH[r] = a);
            }
            s && !i && this.k(t);
        }
        k(t) {
            t === T
                ? this.element.removeAttribute(this.name)
                : this.element.setAttribute(this.name, null != t ? t : '');
        }
    }
    class M extends q {
        constructor() {
            super(...arguments), (this.type = 3);
        }
        k(t) {
            this.element[this.name] = t === T ? void 0 : t;
        }
    }
    class j extends q {
        constructor() {
            super(...arguments), (this.type = 4);
        }
        k(t) {
            t && t !== T
                ? this.element.setAttribute(this.name, '')
                : this.element.removeAttribute(this.name);
        }
    }
    class Q extends q {
        constructor(t, e, o, i, n) {
            super(t, e, o, i, n), (this.type = 5);
        }
        _$AI(t, e = this) {
            var o;
            if ((t = null !== (o = B(this, t, e, 0)) && void 0 !== o ? o : T) === I) return;
            const i = this._$AH,
                n =
                    (t === T && i !== T) ||
                    t.capture !== i.capture ||
                    t.once !== i.once ||
                    t.passive !== i.passive,
                s = t !== T && (i === T || n);
            n && this.element.removeEventListener(this.name, this, i),
                s && this.element.addEventListener(this.name, this, t),
                (this._$AH = t);
        }
        handleEvent(t) {
            var e, o;
            'function' == typeof this._$AH
                ? this._$AH.call(
                      null !==
                          (o = null === (e = this.options) || void 0 === e ? void 0 : e.host) &&
                          void 0 !== o
                          ? o
                          : this.element,
                      t
                  )
                : this._$AH.handleEvent(t);
        }
    }
    class z {
        constructor(t, e, o) {
            (this.element = t),
                (this.type = 6),
                (this._$AN = void 0),
                (this._$AM = e),
                (this.options = o);
        }
        get _$AU() {
            return this._$AM._$AU;
        }
        _$AI(t) {
            B(this, t);
        }
    }
    var V, D, F;
    null === (u = globalThis.litHtmlPolyfillSupport) || void 0 === u || u.call(globalThis, L, H),
        (null !== (d = globalThis.litHtmlVersions) && void 0 !== d
            ? d
            : (globalThis.litHtmlVersions = [])
        ).push('2.0.0');
    class G extends c {
        constructor() {
            super(...arguments), (this.renderOptions = { host: this }), (this._$Dt = void 0);
        }
        createRenderRoot() {
            var t, e;
            const o = super.createRenderRoot();
            return (
                (null !== (t = (e = this.renderOptions).renderBefore) && void 0 !== t) ||
                    (e.renderBefore = o.firstChild),
                o
            );
        }
        update(t) {
            const e = this.render();
            this.hasUpdated || (this.renderOptions.isConnected = this.isConnected),
                super.update(t),
                (this._$Dt = ((t, e, o) => {
                    var i, n;
                    const s =
                        null !== (i = null == o ? void 0 : o.renderBefore) && void 0 !== i ? i : e;
                    let r = s._$litPart$;
                    if (void 0 === r) {
                        const t =
                            null !== (n = null == o ? void 0 : o.renderBefore) && void 0 !== n
                                ? n
                                : null;
                        s._$litPart$ = r = new H(
                            e.insertBefore(_(), t),
                            t,
                            void 0,
                            null != o ? o : {}
                        );
                    }
                    return r._$AI(t), r;
                })(e, this.renderRoot, this.renderOptions));
        }
        connectedCallback() {
            var t;
            super.connectedCallback(),
                null === (t = this._$Dt) || void 0 === t || t.setConnected(!0);
        }
        disconnectedCallback() {
            var t;
            super.disconnectedCallback(),
                null === (t = this._$Dt) || void 0 === t || t.setConnected(!1);
        }
        render() {
            return I;
        }
    }
    function Z(t, e) {
        let o = t;
        const i = (e || '').split('/'),
            n = i.length;
        i.forEach((t, e) => {
            Object.prototype.hasOwnProperty.call(o, t) && (e === n - 1 ? delete o[t] : (o = o[t]));
        });
    }
    (G.finalized = !0),
        (G._$litElement$ = !0),
        null === (V = globalThis.litElementHydrateSupport) ||
            void 0 === V ||
            V.call(globalThis, { LitElement: G }),
        null === (D = globalThis.litElementPolyfillSupport) ||
            void 0 === D ||
            D.call(globalThis, { LitElement: G }),
        (null !== (F = globalThis.litElementVersions) && void 0 !== F
            ? F
            : (globalThis.litElementVersions = [])
        ).push('3.0.0');
    const J = 'surveyTriggerButton';
    function W(t) {
        return !(!t.QSI || !t.QSI.API || 'function' != typeof t.QSI.API.unload);
    }
    const K = {
            init: function (t) {
                const {
                    interceptUrl: e,
                    globalObj: o,
                    contextRootPath: i,
                    contextParamPaths: n,
                    customContextParamPaths: s,
                    surveyLaunchMethod: r
                } = t;
                return new Promise((t, a) => {
                    if (e)
                        try {
                            const l = {},
                                h = () => {
                                    var e, c;
                                    o.QSI.API
                                        ? ((l.QSI = o.QSI),
                                          (l.apiLoadedListener = h),
                                          (l.setParameters = new Set([])),
                                          (l.globalObj = o),
                                          (l.destroyed = !1),
                                          (l.firstNonExistingRoot = (function (t, e) {
                                              if ('string' != typeof e || 0 === e.length)
                                                  return null;
                                              const o = e.split('/');
                                              let i = '',
                                                  n = t;
                                              for (let t = 0; t < o.length; t++) {
                                                  const e = o[t];
                                                  if (!Object.prototype.hasOwnProperty.call(n, e))
                                                      return i + (0 === i.length ? '' : '/') + e;
                                                  (n = n[e]), (i += (0 === t ? '' : '/') + e);
                                              }
                                              return e === i ? null : i;
                                          })(o, i)),
                                          (l.contextRootPath = i),
                                          (l.contextParamPaths =
                                              ((e = n),
                                              (c = s),
                                              Object.keys(e || {}).reduce(
                                                  (t, o) => ((t[o] = e[o]), t),
                                                  JSON.parse(JSON.stringify(c || {}))
                                              ))),
                                          (l.surveyLaunchMethod = r),
                                          t(l))
                                        : a(
                                              new Error(
                                                  'Survey intercept was loaded but API could not be found'
                                              )
                                          );
                                };
                            if (!o.document || !o.document.body)
                                throw new Error(
                                    'Cannot inject elements in the document: document.body is not available.'
                                );
                            switch (r) {
                                case 'invisibleButton':
                                    if (document.getElementById(J))
                                        throw new Error(
                                            "An element with id surveyTriggerButton already exists in this page. The survey won't be launched unless the existing button is removed or its id is renamed."
                                        );
                                    const t = (function () {
                                        const t = document.createElement('button');
                                        return (
                                            t.setAttribute('id', 'surveyTriggerButton'),
                                            (t.style.display = 'none'),
                                            document.body.appendChild(t),
                                            t
                                        );
                                    })();
                                    l.invisibleButtonElement = t;
                                    break;
                                case 'qsiApi':
                                    break;
                                default:
                                    throw new Error(`Unsupported launch method: ${r}.`);
                            }
                            W(o)
                                ? o.QSI.API.load().then(h)
                                : (!(function (t, e) {
                                      const o = e.document.createElement('script');
                                      (o.type = 'text/javascript'),
                                          (o.src = t),
                                          e.document.body.appendChild(o);
                                  })(e, o),
                                  o.addEventListener('qsi_js_loaded', h, !1));
                        } catch (t) {
                            a(t);
                        }
                    else
                        a(
                            new Error(
                                'No intercept URL was provided. This is a mandatory parameter.'
                            )
                        );
                });
            },
            destroy: function (t) {
                W(t) && t.QSI.API.unload(),
                    t.apiLoadedListener &&
                        t.globalObj.removeEventListener('qsi_js_loaded', t.apiLoadedListener);
                let e = t.contextRootPath;
                t.firstNonExistingRoot
                    ? Z(t.globalObj, t.firstNonExistingRoot)
                    : t.setParameters.forEach((o) => {
                          const i = t.contextParamPaths[o];
                          i && (e = `${e}/${i}`), Z(t.globalObj, e);
                      }),
                    t.invisibleButtonElement && t.invisibleButtonElement.remove(),
                    (t.destroyed = !0);
            },
            setContextParameters: function (t, e) {
                const o = (function (t, e, o) {
                    2 === arguments.length && (o = !0);
                    let i = t;
                    const n = (e || '').split('/');
                    for (const t of n) {
                        if (!Object.prototype.hasOwnProperty.call(i, t)) {
                            if (!o) return;
                            i[t] = {};
                        }
                        i = i[t];
                    }
                    return i;
                })(t.globalObj, t.contextRootPath);
                Object.keys(e).forEach((i) => {
                    const n = t.contextParamPaths[i] || i;
                    !(function (t, e, o) {
                        let i = t;
                        if ('' === e) throw new Error('Path cannot be empty');
                        const n = (e || '').split('/'),
                            s = n.length;
                        n.forEach((t, e) => {
                            Object.prototype.hasOwnProperty.call(i, t) || (i[t] = {}),
                                e === s - 1 && (i[t] = o),
                                (i = i[t]);
                        });
                    })(o, n, e[i]),
                        t.setParameters.add(i);
                });
            },
            startSurvey: function (t) {
                if (0 === t.setParameters.size)
                    throw new Error(
                        'Cannot start a survey without context parameters. Call setContextParameters first.'
                    );
                'invisibleButton' !== t.surveyLaunchMethod
                    ? (t.QSI.API.unload(), t.QSI.API.load().then(t.QSI.API.run.bind(t.QSI.API)))
                    : t.invisibleButtonElement &&
                      t.invisibleButtonElement.dispatchEvent(new Event('click'));
            }
        },
        Y = 'cx-qtx-sbtn-timestamp',
        X = 'cx-qtx-sbtn-localstorage-test';
    const tt = {
        saveUserInteractionTime: function (t) {
            if (t.enabled)
                try {
                    t.globalObj.localStorage.setItem(Y, +new Date());
                } catch (t) {
                    return;
                }
        },
        determineNotificationStatus: function (t) {
            return new Promise((e, o) => {
                var i;
                if (!t.enabled) return void e(!1);
                if (
                    !(function (t) {
                        var e;
                        if ('boolean' == typeof t._IS_LOCAL_STORAGE_AVAILABLE_CACHE)
                            return t._IS_LOCAL_STORAGE_AVAILABLE_CACHE;
                        const o =
                            null == t || null === (e = t.globalObj) || void 0 === e
                                ? void 0
                                : e.localStorage;
                        let i;
                        try {
                            o.setItem(X, 'true'), o.removeItem(X), (i = !0);
                        } catch (t) {
                            i = !1;
                        }
                        return (t._IS_LOCAL_STORAGE_AVAILABLE_CACHE = i), i;
                    })(t)
                )
                    return void e(!1);
                const n = null == t || null === (i = t.range) || void 0 === i ? void 0 : i.type;
                if ('months' !== n) return void o(new Error(`Invalid range type configured: ${n}`));
                const s = new Date().getMonth() + 1,
                    r = (function (t) {
                        var e, o;
                        return 'months' ===
                            (null == t || null === (e = t.range) || void 0 === e ? void 0 : e.type)
                            ? null == t || null === (o = t.range) || void 0 === o
                                ? void 0
                                : o.value.map((t) => window.parseInt(t, 10))
                            : [];
                    })(t),
                    a = r.indexOf(s) >= 0,
                    l = (function (t) {
                        try {
                            return t.globalObj.localStorage.getItem(Y);
                        } catch (t) {
                            return null;
                        }
                    })(t);
                if (!l) return void e(a);
                const h = parseInt(l, 10),
                    c = new Date(h).getMonth() + 1;
                e(a && s !== c);
            });
        }
    };
    let et,
        ot,
        it,
        nt,
        st = (t) => t;
    class rt extends G {
        constructor() {
            super(),
                (this._version = '1.0.2'),
                (this.apiContext = null),
                (this.notifyUser = null),
                (this.surveyLaunchMethod = 'invisibleButton'),
                (this.contextParams = {}),
                (this.fiori3Compatible = !1),
                (this.interceptUrl = ''),
                (this.contextRootPath = 'sap/qtx'),
                (this.notificationConfig = {
                    enabled: !0,
                    range: { type: 'months', value: [2, 5, 8, 11] }
                }),
                (this.title = 'Give Feedback'),
                (this.ariaLabel = 'Give Feedback'),
                (this.contextParamPaths = {
                    Q_Language: 'appcontext/languageTag',
                    language: 'appcontext/languageTag',
                    appFrameworkVersion: 'appcontext/appFrameworkVersion',
                    theme: 'appcontext/theme',
                    appId: 'appcontext/appId',
                    appVersion: 'appcontext/appVersion',
                    technicalAppComponentId: 'appcontext/technicalAppComponentId',
                    appTitle: 'appcontext/appTitle',
                    appSupportInfo: 'appcontext/appSupportInfo',
                    tenantId: 'session/tenantId',
                    tenantRole: 'session/tenantRole',
                    appFrameworkId: 'appcontext/appFrameworkId',
                    productName: 'session/productName',
                    platformType: 'session/platformType',
                    pushSrcType: 'push/pushSrcType',
                    pushSrcAppId: 'push/pushSrcAppId',
                    pushSrcTrigger: 'push/pushSrcTrigger',
                    clientAction: 'appcontext/clientAction',
                    previousTheme: 'appcontext/previousTheme',
                    followUpCount: 'appcontext/followUpCount',
                    deviceType: 'device/type',
                    orientation: 'device/orientation',
                    osName: 'device/osName',
                    browserName: 'device/browserName'
                }),
                (this.customContextParamPaths = {});
        }
        static get properties() {
            return {
                title: { type: String, attribute: 'title', reflect: !1 },
                ariaLabel: { type: String, attribute: 'aria-label', reflect: !1 },
                surveyLaunchMethod: {
                    type: String,
                    attribute: 'survey-launch-method',
                    reflect: !1
                },
                notifyUser: { type: Boolean, attribute: 'notify-user', reflect: !0 },
                notificationConfig: { type: Object, attribute: 'notification-config', reflect: !0 },
                interceptUrl: { type: String, attribute: 'intercept-url', reflect: !0 },
                customContextParamPaths: {
                    type: Object,
                    attribute: 'custom-context-param-paths',
                    reflect: !0
                },
                contextParamPaths: { type: Object, attribute: 'context-param-paths', reflect: !0 },
                contextRootPath: { type: String, attribute: 'context-root-path', reflect: !0 },
                contextParams: { type: Object, attribute: 'context-params', reflect: !0 },
                fiori3Compatible: { type: Boolean, attribute: 'fiori3-compatible', reflect: !0 }
            };
        }
        _onClick() {
            this._turnOffNotification(),
                tt.saveUserInteractionTime({ ...this.notificationConfig, globalObj: window }),
                this._runSurvey();
        }
        _turnOffNotification() {
            (this.notifyUser = !1), this.requestUpdate();
        }
        _runSurvey() {
            this._getAPIContext().then(
                (t) => {
                    const e = this.contextParams;
                    (this.apiContext = t),
                        K.setContextParameters(this.apiContext, e),
                        K.startSurvey(this.apiContext);
                },
                (t) => {
                    console.log(t);
                }
            );
        }
        _getAPIContext() {
            return this.apiContext
                ? Promise.resolve(this.apiContext)
                : K.init({
                      interceptUrl: this.interceptUrl,
                      globalObj: window,
                      contextRootPath: this.contextRootPath,
                      contextParamPaths: this.contextParamPaths,
                      customContextParamPaths: this.customContextParamPaths,
                      surveyLaunchMethod: this.surveyLaunchMethod
                  });
        }
        setContextParams(t) {
            this.contextParams = JSON.parse(JSON.stringify(t));
        }
        updateContextParam(t, e) {
            this.contextParams[t] = e;
        }
        connectedCallback() {
            super.connectedCallback(),
                this.addEventListener('click', this._onClick),
                this.setAttribute('aria-hidden', 'true'),
                tt
                    .determineNotificationStatus({ ...this.notificationConfig, globalObj: window })
                    .then(
                        (t) => {
                            null === this.notifyUser &&
                                ((this.notifyUser = t), this.requestUpdate());
                        },
                        (t) => {
                            console.log(t);
                        }
                    );
        }
        disconnectedCallback() {
            super.disconnectedCallback(),
                this.removeEventListener('click', this._onClick),
                this.apiContext && (K.destroy(this.apiContext), (this.apiContext = null));
        }
        render() {
            const t = this.fiori3Compatible
                ? k(
                      et ||
                          (et = st`<svg
  version="1.1"
  viewBox="0 0 16 15"
  width="16"
  height="15"
  xmlns="http://www.w3.org/2000/svg"
  xmlns:svg="http://www.w3.org/2000/svg"
>
  <g class="pathGroup">
      <path
          class="backgroundCircle"
          style="stroke-width:0.0257446"
          d="m 11.5,0.79276785 q 0.77234,0 1.441702,0.29606375 0.66936,0.2960636 1.171381,0.7980845 0.502022,0.5020211 0.798086,1.1713824 0.296063,0.6693614 0.296063,1.4417015 0,0.77234 -0.296063,1.4417015 Q 14.615105,6.6110627 14.113083,7.1130839 13.611062,7.6151046 12.941702,7.9111681 12.27234,8.2072317 11.5,8.2072317 q -0.77234,0 -1.441701,-0.2960636 Q 9.3889383,7.6151046 8.8869163,7.1130839 8.3848954,6.6110627 8.0888316,5.9417015 7.792768,5.27234 7.792768,4.5 q 0,-0.7723401 0.2960636,-1.4417015 Q 8.3848954,2.3889372 8.8869163,1.8869161 9.3889383,1.3848952 10.058299,1.0888316 10.72766,0.79276785 11.5,0.79276785 Z"
      />
      <path
          class="foregroundIcon"
          d="m 11.5,0 q 0.9375,0 1.75,0.359375 0.8125,0.35937501 1.421874,0.96875 Q 15.28125,1.9375 15.640626,2.75 16,3.5625 16,4.5 16,5.4375001 15.640626,6.2500002 15.28125,7.0625 14.671874,7.6718752 14.0625,8.2812502 13.25,8.6406251 12.4375,8.9999998 11.5,8.9999998 q -0.9375,0 -1.7499995,-0.3593747 Q 8.9375006,8.2812502 8.3281251,7.6718752 7.7187501,7.0625 7.359375,6.2500002 7.0000001,5.4375001 7.0000001,4.5 q 0,-0.9375 0.3593749,-1.75 Q 7.7187501,1.9375 8.3281251,1.328125 8.9375006,0.71875001 9.7500005,0.359375 10.5625,0 11.5,0 Z M 7.9375002,4.5 q 0,0.7500001 0.2812498,1.3906251 Q 8.5,6.53125 8.984375,7.0156251 9.4687505,7.5000001 10.109376,7.7812502 10.75,8.0625 11.5,8.0625 q 0.75,0 1.390624,-0.2812498 Q 13.53125,7.5000001 14.015625,7.0156251 14.5,6.53125 14.78125,5.8906251 15.062499,5.2500001 15.062499,4.5 q 0,-0.75 -0.281249,-1.3906249 Q 14.5,2.4687501 14.015625,1.9843751 13.53125,1.5 12.890624,1.21875 12.25,0.93750001 11.5,0.93750001 q -0.75,0 -1.390624,0.28124999 Q 9.4687505,1.5 8.984375,1.9843751 8.5,2.4687501 8.21875,3.1093751 7.9375002,3.75 7.9375002,4.5 Z M 0,3.9999998 Q 0,3.1875001 0.59375,2.59375 1.1875,2.0000002 2.0000002,2.0000002 h 4.59375 Q 6.375,2.40625 6.2187502,3 h -4.21875 Q 1.5624999,3 1.28125,3.3124999 0.99999999,3.59375 0.99999999,3.9999998 v 6.0000001 q 0,0.4375001 0.28125001,0.7187491 Q 1.5624999,11 2.0000002,11 h 1.9999996 v 2.500001 L 6.0000001,11.03125 13.000001,11 q 0.4375,0 0.718749,-0.281251 Q 14,10.4375 14,10.000001 V 9.406253 Q 14.3125,9.218753 14.5625,9.0625025 14.8125,8.9062526 15,8.7500027 v 1.2500003 q 0,0.84375 -0.578124,1.421875 -0.578126,0.578125 -1.421875,0.578125 H 6.5000001 l -2.4375,2.875 q -0.125,0.125001 -0.4062502,0.125001 -0.2499998,0 -0.4531248,-0.171875 Q 3,14.656254 3,14.375003 V 12.000004 H 2.0000002 q -0.8437503,0 -1.4218752,-0.578125 Q 0,10.84375 0,9.9999999 Z M 12.09375,3.0625001 Q 12.09375,2.75 12.296874,2.59375 12.5,2.4375 12.750001,2.4375 q 0.25,0 0.437499,0.15625 0.1875,0.15625 0.1875,0.4687501 0,0.3125 -0.1875,0.4687501 Q 13.000001,3.6875 12.750001,3.6875 12.5,3.6875 12.296874,3.5312502 12.09375,3.3750001 12.09375,3.0625001 Z M 10.249999,2.4375 q 0.25,0 0.437501,0.15625 0.187501,0.15625 0.187501,0.4687501 0,0.3125 -0.187501,0.4687501 Q 10.499999,3.6875 10.249999,3.6875 9.9999999,3.6875 9.7968755,3.5312502 9.5937501,3.3750001 9.5937501,3.0625001 9.5937501,2.75 9.7968755,2.59375 9.9999999,2.4375 10.249999,2.4375 Z m -1.0937487,2.7499999 0.062501,-0.062499 q 0.093749,-0.093751 0.21875,-0.093751 0.1562504,0 0.2500004,0.125 0.8437513,0.9375001 1.8124993,0.9375001 1.031251,0 1.8125,-0.9375001 0.09374,-0.093751 0.25,-0.093751 0.125,0 0.21875,0.093751 h 0.03125 q 0,0.031249 0.01561,0.031249 0.01562,0 0.01562,0.03125 0.125001,0.1249999 0.125001,0.21875 0,0.125 -0.09376,0.21875 -0.5,0.6250001 -1.109375,0.9218751 -0.609376,0.2968747 -1.234374,0.2968747 -0.625001,0 -1.250001,-0.2968747 Q 9.6562318,6.2812505 9.1249813,5.6562504 9.0312322,5.5625 9.0312322,5.4687503 q 0,-0.03125 0.015627,-0.109375 0.015628,-0.078125 0.1093752,-0.1718751 z"
          style="stroke-width:0.0312499"
      />
  </g>
</svg>
`)
                  )
                : k(
                      ot ||
                          (ot = st`<svg
    version="1.1"
    width="18.190166"
    height="20"
    viewBox="0 0 18.190167 20"
    xmlns="http://www.w3.org/2000/svg"
    xmlns:svg="http://www.w3.org/2000/svg"
>
    <g class="pathGroup">
        <path
            d="M 3.665181,2.7601972 H 2.7601972 c -0.9996179,0 -1.80996746,0.8103496 -1.80996746,1.8099675 v 9.0498373 c 0,0.999645 0.81034956,1.809967 1.80996746,1.809967 h 1.8099675 v 3.619936 L 8.1900998,15.429969 H 15.42997 c 0.999645,0 1.809967,-0.810322 1.809967,-1.809967 v -0.904984"
            stroke-linecap="round"
            stroke-linejoin="round"
        />
        <path
            class="smiley"
            fill-rule="evenodd"
            clip-rule="evenodd"
            d="m 11.810035,11.810035 c 2.998844,0 5.429902,-2.4310584 5.429902,-5.4299028 0,-2.9988537 -2.431058,-5.42990246 -5.429902,-5.42990246 -2.9988444,0 -5.4299028,2.43104876 -5.4299028,5.42990246 0,2.9988444 2.4310584,5.4299028 5.4299028,5.4299028 z"
            stroke-linecap="round"
            stroke-linejoin="round"
        />
        <path
            d="m 10.000068,7.2851161 c 0,0 0.452491,0.9049837 1.809967,0.9049837 1.357475,0 1.809967,-0.9049837 1.809967,-0.9049837"
            stroke-linecap="round"
            stroke-linejoin="round"
        />
        <path
            class="eye"
            fill-rule="evenodd"
            clip-rule="evenodd"
            d="m 10.000068,5.4751485 c 0.499821,0 0.904983,-0.4051794 0.904983,-0.9049838 0,-0.4998044 -0.405162,-0.9049838 -0.904983,-0.9049838 -0.4998231,0 -0.904984,0.4051794 -0.904984,0.9049838 0,0.4998044 0.4051609,0.9049838 0.904984,0.9049838 z"
        />
        <path
            class="eye"
            fill-rule="evenodd"
            clip-rule="evenodd"
            d="m 13.620002,5.4751485 c 0.499823,0 0.904984,-0.4051794 0.904984,-0.9049838 0,-0.4998044 -0.405161,-0.9049838 -0.904984,-0.9049838 -0.499822,0 -0.904984,0.4051794 -0.904984,0.9049838 0,0.4998044 0.405162,0.9049838 0.904984,0.9049838 z"
        />
    </g>
</svg>
`)
                  );
            return k(
                it ||
                    (it = st`
            <button title="${0}" aria-label="${0}">
                ${0}
            </button>
        `),
                this.title,
                this.ariaLabel,
                t
            );
        }
        static get styles() {
            return ((t, ...o) => {
                const n =
                    1 === t.length
                        ? t[0]
                        : o.reduce(
                              (e, o, i) =>
                                  e +
                                  ((t) => {
                                      if (!0 === t._$cssResult$) return t.cssText;
                                      if ('number' == typeof t) return t;
                                      throw Error(
                                          "Value passed to 'css' function must be a 'css' function result: " +
                                              t +
                                              ". Use 'unsafeCSS' to pass non-literal values, but take care to ensure page security."
                                      );
                                  })(o) +
                                  t[i + 1],
                              t[0]
                          );
                return new i(n, e);
            })(
                nt ||
                    (nt = st`/*
 * Prevent focus effect on the host, the button only should be focussed.
 */
:host(:focus) {
    outline: none;
    box-shadow: none;
}

:host(:focus) button {
    background-color: initial;
}

button {
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    width: var(--qtxSurveyButton_Size, 2rem);
    height: var(--qtxSurveyButton_Size, 2rem);

    outline: none;

    shape-rendering: geometricprecision;

    /* Fiori Next buttons have transitions */
    -webkit-transition: 0.3s ease-in-out;
    transition: 0.3s ease-in-out;

    font-weight: 400;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    margin: 0;
    border: 0;
    -webkit-box-pack: center;
    -ms-flex-pack: center;
    justify-content: center;
    -webkit-box-align: center;
    -ms-flex-align: center;
    align-items: center;
    cursor: pointer;
    position: relative;
    padding: 6px;
    -webkit-box-shadow: none;
    box-shadow: none;
    border-radius: var(--sapButton_BorderCornerRadius, 0.5rem);
    background: 0 0;
}

button.is-focus,
button:focus {
    z-index: 5;
    background: var(--sapShell_Hover_Background, transparent);
    outline: 0;
    border-color: #fff;
    -webkit-box-shadow: 0 0 2px rgba(27, 144, 255, 0.16),
        0 8px 16px rgba(27, 144, 255, 0.16), 0 0 0 0.125rem #1b90ff,
        inset 0 0 0 0.125rem #fff;
    box-shadow: 0 0 2px rgba(27, 144, 255, 0.16),
        0 8px 16px rgba(27, 144, 255, 0.16), 0 0 0 0.125rem #1b90ff,
        inset 0 0 0 0.125rem #fff;
}

:host([fiori3-compatible]) button {
    /*
     * Fiori 3: use correct sizing
     */
    width: var(--qtxSurveyButton_Size, 2.25rem);
    height: var(--qtxSurveyButton_Size, 2.25rem);

    /*
     * Fiori 3: disable Fiori Next transitions + box shadow
     */
    -webkit-transition: none;
    transition: none;
    box-shadow: none;
    -webkit-box-shadow: none;
}
:host([fiori3-compatible]):host(:hover) button {
    box-shadow: none;
    -webkit-box-shadow: none;
}
:host([fiori3-compatible]):host(:active) button {
    box-shadow: none;
    -webkit-box-shadow: none;
}

/*
 * Fiori3: create visible focus area
 */
:host([fiori3-compatible]):host(:focus) button:after {
    content: "";
    position: absolute;
    width: auto;
    height: auto;
    top: 0.0625rem;
    left: 0.0625rem;
    right: 0.0625rem;
    bottom: 0.0625rem;
    border: var(--sapContent_FocusWidth, 0.0625rem) dotted
        var(--sapContent_ContrastFocusColor, #fff);
    border-radius: 4px;
}

:host(:hover) button {
    background-color: var(--sapShell_Hover_Background, transparent);

    -webkit-box-shadow: 0 0 2px rgba(131, 150, 168, 0.16),
        0 8px 16px rgba(131, 150, 168, 0.16);
    box-shadow: 0 0 2px rgba(131, 150, 168, 0.16),
        0 8px 16px rgba(131, 150, 168, 0.16);
}
:host(:hover) path {
    stroke: var(--sapShell_Active_TextColor, #475e75);
}
:host(:hover) .eye,
:host(:hover) .foregroundIcon {
    fill: var(--sapShell_Active_TextColor, #475e75);
    stroke: transparent;
}
:host(:active) button {
    -webkit-box-shadow: 0 0 2px rgba(131, 150, 168, 0.16),
        0 2px 4px rgba(131, 150, 168, 0.16);
    box-shadow: 0 0 2px rgba(131, 150, 168, 0.16),
        0 2px 4px rgba(131, 150, 168, 0.16);
    background: var(--sapShell_Active_Background, #fff);
}

:host([notify-user]) .smiley,
:host([notify-user]) .backgroundCircle {
    fill: var(
        --qtxSurveyButton_NotificationColor,
        #64edd2
    ); /* Teal 2 */
}
:host([notify-user][fiori3-compatible]) .smiley,
:host([notify-user][fiori3-compatible]) .backgroundCircle {
    fill: var(
        --qtxSurveyButton_NotificationColor,
        var(--sapIndicationColor_6, #0f828f)
    );
}

:host([fiori3-compatible]) .pathGroup {
    transform: scale(var(--qtxSurveyButton_IconScale, 1))
        translate(0, var(--qtxSurveyButton_IconOffsetY, 0));
}
.pathGroup {
    transform: scale(var(--qtxSurveyButton_IconScale, 1))
        translate(0, var(--qtxSurveyButton_IconOffsetY, 0));
    transform-origin: center;
    fill: none;
}

path {
    stroke: var(--sapShell_InteractiveTextColor, #5b738b);
    stroke-width: 2px;
    vector-effect: non-scaling-stroke;
}
.eye,
.foregroundIcon {
    fill: var(--sapShell_InteractiveTextColor, #5b738b);
    stroke: transparent;
}

button::after,
button::before {
    -webkit-box-sizing: inherit;
    box-sizing: inherit;
    font-size: inherit;
}

button.is-pressed,
button[aria-pressed="true"] {
    -webkit-box-shadow: 0 0 2px rgba(131, 150, 168, 0.16),
        0 2px 4px rgba(131, 150, 168, 0.16);
    box-shadow: 0 0 2px rgba(131, 150, 168, 0.16),
        0 2px 4px rgba(131, 150, 168, 0.16);
    background: var(--sapShell_Active_Background, #fff);
}
`)
            );
        }
    }
    var at, lt, ht;
    (at = rt),
        (lt = 'shadowRootOptions'),
        (ht = { ...G.shadowRootOptions, mode: 'closed', delegatesFocus: 'true' }),
        lt in at
            ? Object.defineProperty(at, lt, {
                  value: ht,
                  enumerable: !0,
                  configurable: !0,
                  writable: !0
              })
            : (at[lt] = ht),
        window.customElements.define('cx-qtx-survey-button', rt);
})();
//# sourceMappingURL=cx-qtx-survey-button.bundle.js.map
